package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.lmsback.domain.*;
import project.lmsback.repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssignmentSubmitServiceImpl implements AssignmentSubmitService {
    private final AssignmentSubmitRepository assignmentSubmitRepository;
    private final LectureInfoRepository lectureInfoRepository;
    private final RegisterClassRepository registerClassRepository;
    private final AttendanceRepository attendanceRepository;
    private final LectureWeekRepository lectureWeekRepository;

    @Override
    public List<AssignmentsViewDTO> assignmentViews(int profId) {

        List<AssignmentsViewDTO> dtos = new ArrayList<>();
        lectureInfoRepository.findByProfessor_ProfId(profId).forEach(lectureInfo -> {
            log.info(">>> 개설강좌번호  >>  {}",lectureInfo.getLectureId());
            List<AssignmentSubmit> list = assignmentSubmitRepository.findByLecture_LectureId(lectureInfo.getLectureId());
            list.forEach(assignment -> {
                AssignmentsViewDTO dto = AssignmentsViewDTO.builder()
                        .lectureId(lectureInfo.getLectureId())
                        .assignmentId(assignment.getAssignmentSubmitId())
                        .stdt_id(assignment.getStudent().getStdtId())
                        .stdt_name(assignment.getStudent().getStdtName())
                        .assignment_name(assignment.getAssignment().getTitle())
                        .submissionDate(assignment.getSubmissionDate())
                        .fileName(assignment.getFile().getFileName())
                        .score(assignment.getScore())
                        .uuid(assignment.getFile().getUuid())
                        .build();

                log.info(">>> dto >>> {} " , dto.toString());
                dtos.add(dto);
            });
        });

        log.info(dtos.toString());

        return dtos;
    }

    @Override
    @Transactional
    public boolean evaluateUpdate(EvaluateUpdateDTO assignmentSubmit) {

        //쿼리문으로 성적 업데이트
        int result = assignmentSubmitRepository.updateViews(assignmentSubmit.getAssignmentId(), assignmentSubmit.getScore());

        log.info("-- {} / {}",assignmentSubmit.getLectureId(), assignmentSubmit.getStdt_id());
        // 성적 산출
        // 특정 개설강좌 > 출석률 와 총 과제 점수 / 총 과제 수 를 5 : 5로 점수 산출
        RegisterClass regi = registerClassRepository.findByLectureId_LectureIdAndStdtId_StdtId(assignmentSubmit.getLectureId(), assignmentSubmit.getStdt_id()).orElseThrow(() -> (
                new UsernameNotFoundException("성적 산출 실패")
        ));


        List<Attendance> att = attendanceRepository.findByRegisterClass_RegisterId(regi.getRegisterId());

        log.info(regi.toString());
        log.info("성적산출 진입>>> ");

        if(att.size() > 0){

            int stdtLectureAttendance = att.size();// 학생이 출석한 횟수
            List<LectureWeek> lecturecount = lectureWeekRepository.findByLecture_LectureId(assignmentSubmit.getLectureId());
            int totlaLecturesCount = lecturecount.size();// 총 강의 횟수
            LectureInfo evaluate = lectureInfoRepository.findByLectureId(assignmentSubmit.getLectureId());//평가 기준 확인
            int a = evaluate.getEvaluatorA();//과제 평가 비중
            int b = evaluate.getEvaluatorB();//출석 평가 비중

            int assignSubmitCount = assignmentSubmitRepository.countByLecture_LectureIdAndStudent_StdtId(assignmentSubmit.getLectureId(), assignmentSubmit.getStdt_id());//특정 학생이 제출한 과제 개수
            int assignCount = assignmentSubmitRepository.countByLecture_LectureId(assignmentSubmit.getLectureId());//특정 개설강좌에 있는 총 과제 갯수

            //출석률(출석한 횟수/총 강의 수)
            double attendanceRate = (stdtLectureAttendance * 1.0 / totlaLecturesCount) * 100;

            //과제 총 점수
            AtomicInteger score = new AtomicInteger(0);
            assignmentSubmitRepository.findByLecture_LectureIdAndStudent_StdtId(assignmentSubmit.getLectureId(), assignmentSubmit.getStdt_id()).forEach(submit -> {
                score.addAndGet(submit.getScore());
            });

            //과제가 있으면 과제 총 점수 / 총 과제 갯수
            double avgAssignmentScore = assignCount > 0 ? (score.get() * 1.0 / assignCount) : 0.0;

            //과제 평가 + 출석 평가
            double finalScore = (avgAssignmentScore * a / 100.0) + (attendanceRate * b / 100.0);

            // 백분위 점수, 성적 평가 등급, GPA 성적 점수 계산
            String grade;
            double gpa;

            if (finalScore >= 95) {
                grade = "A+";
                gpa = 4.5;
            } else if (finalScore >= 90) {
                grade = "A0";
                gpa = 4.0;
            } else if (finalScore >= 85) {
                grade = "B+";
                gpa = 3.5;
            } else if (finalScore >= 80) {
                grade = "B0";
                gpa = 3.0;
            } else if (finalScore >= 75) {
                grade = "C+";
                gpa = 2.5;
            } else if (finalScore >= 70) {
                grade = "C0";
                gpa = 2.0;
            } else if (finalScore >= 65) {
                grade = "D+";
                gpa = 1.5;
            } else if (finalScore >= 60) {
                grade = "D0";
                gpa = 1.0;
            } else {
                grade = "F";
                gpa = 0.0;
            }

            log.info("최종 성적: {}, 등급: {}, GPA: {}", finalScore, grade, gpa);

            RegisterClass insertDTO = registerClassRepository.findByRegisterId(regi.getRegisterId());

            insertDTO.setAttendanceRate((int)attendanceRate);
            insertDTO.setAttendanceScore((int)attendanceRate);
            insertDTO.setAssignmentScore((int)avgAssignmentScore);
            insertDTO.setPercentileScore((int)finalScore);
            insertDTO.setGpaScore(gpa);
            insertDTO.setGradeEvaluation(grade);

            log.info(">>> insert >>> {} ",insertDTO.toString());
        }else {
            log.info("학생 출석 기록이 없음.");
        }
        return true;
    }
}
