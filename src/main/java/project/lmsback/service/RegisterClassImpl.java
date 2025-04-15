package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.*;
import project.lmsback.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterClassImpl implements RegisterClassService{

    private final RegisterClassRepository registerClassRepository;
    private final StudentRepository studentRepository;
    private final AssignmentSubmitRepository assignmentSubmitRepository;
    private final LectureWeekRepository lectureWeekRepository;
    private final AttendanceRepository attendanceRepository;
    private final LectureAssignmentRepository lectureAssignmentRepository;
    private final LectureInfoRepository lectureInfoRepository;

    @Override
    public List<StudentProfileDTO> classUserList(Integer profId) {
        List<StudentProfileDTO> result = new ArrayList<>();
        List<LectureInfo> lectureInfos = lectureInfoRepository.findByProfessor_ProfId(profId);

        for (LectureInfo lectureInfo : lectureInfos) {
            System.err.println(lectureInfo.getLectureId());
            List<RegisterClass> registerClassList = registerClassRepository.findByLectureId_LectureId(lectureInfo.getLectureId());

            List<LectureWeek> lectureweeks = lectureWeekRepository.findByLecture_LectureId(lectureInfo.getLectureId());
            long totalWeeks = lectureweeks.size();

            for (RegisterClass registerClass : registerClassList) {
                StudentInfo studentInfo = studentRepository.findByStdtId(registerClass.getStdtId().getStdtId())
                        .orElseThrow(() -> new IllegalArgumentException("해당 학생이 존재하지 않습니다."));

                List<Attendance> attendances = attendanceRepository.findByRegisterClass(registerClass);

                Map<Integer, Long> weekAttendanceCount = attendances.stream()
                        .filter(attendance -> attendance.getIsAttended() != null && attendance.getIsAttended())
                        .collect(Collectors.groupingBy(
                                attendance -> attendance.getContent().getWeek().getWeekNumber(),
                                Collectors.counting()
                        ));

                long attendedWeeks = weekAttendanceCount.size();
                double attendanceRate = totalWeeks > 0 ? (double) attendedWeeks / totalWeeks : 0.0;

                List<LectureAssignment> assignments = lectureAssignmentRepository.findByLecture_LectureId(lectureInfo.getLectureId());
                int totalAssignments = assignments.size();

                int studentsubmitcount = assignmentSubmitRepository
                        .countByLecture_LectureIdAndStudent_StdtId(lectureInfo.getLectureId(), registerClass.getStdtId().getStdtId());

                double submitRate = totalAssignments > 0 ? (double) studentsubmitcount / totalAssignments : 0.0;

                StudentProfileDTO dto = StudentProfileDTO.builder()
                        .stdtId(studentInfo.getStdtId())
                        .stdtName(studentInfo.getStdtName())
                        .email(studentInfo.getEmail())
                        .major(studentInfo.getMajor())
                        .hpNo(studentInfo.getHpNo())
                        .progressRate(attendanceRate)
                        .submissionRate(submitRate)
                        .build();

                log.info("등록된 학생 ID: {}", studentInfo.getStdtId());
                log.info("현재까지 result size: {}", result.size());

                result.add(dto);
            }
        }
        return result;
    }


    @Override
    public List<StudentProfileDTO> classMassageList(Integer lectureId) {
        List<StudentProfileDTO> dtos = new ArrayList<>();
        List<RegisterClass> list = registerClassRepository.findByLectureId_LectureId(lectureId);
        list.forEach(registerClass -> {
            dtos.add(StudentProfileDTO.builder()
                    .stdtId(registerClass.getStdtId().getStdtId())
                    .lectureId(registerClass.getLectureId().getLectureId())
                    .profId(registerClass.getLectureId().getProfessor().getProfId())
                    .build()
            );
        });
        return dtos;
    }
}
