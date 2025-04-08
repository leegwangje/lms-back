package project.lmsback.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.*;
import project.lmsback.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyCourserServiceImpl implements MyCourserService {
    private final RegisterClassRepository registerClassRepository;
    private final LectureWeekRepository lectureWeekRepository;
    private final LectureContentRepository lectureContentRepository;
    private final LectureAssignmentRepository lectureAssignmentRepository;
    private final AssignmentSubmitRepository assignmentSubmitRepository;

    @Override
    public List<MycourseDTO> getCoursesByStudentId(Integer stdtId) {
        log.info("getCoursesByStudentId: {}", stdtId);

        List<RegisterClass> registered = registerClassRepository.findByStudent_StdtId(stdtId);

        log.info("등록된 수강 강의 개수: {}", registered.size());

        return registered.stream().map(reg -> {
            LectureInfo lecture = reg.getLecture();

            if (lecture == null) {
                log.warn("lecture is null for registerId: {}", reg.getRegisterId());
            }

            MycourseDTO dto = new MycourseDTO();
            dto.setLectureId(lecture.getLectureId());
            dto.setSubjectName(lecture.getSubjectName());
            dto.setDepartment(lecture.getDepartment());
            return dto;
        }).toList();
    }

    @Override
    public List<LectureWeekDTO> getWeeksByLectureId(Integer lectureId) {
        return lectureWeekRepository.findByLecture_LectureId(lectureId).stream()
                .map(week -> {
                    LectureWeekDTO dto = new LectureWeekDTO();
                    dto.setWeekId(week.getWeekId());
                    dto.setLectureId(week.getLecture().getLectureId());
                    return dto;
                })
                .toList();
    }

    @Override
    public List<LectureContentDTO> getContentsByWeekId(Integer weekId) {
        return lectureContentRepository.findByWeek_WeekId(weekId).stream()
                .map(content -> {
                    LectureContentDTO dto = new LectureContentDTO();
                    dto.setLectureManagementId(content.getLectureManagementId());
                    dto.setChapterName(content.getChapterName());
                    dto.setOrderName(content.getOrderName());
                    dto.setYoutubeVideoId(content.getYoutubeVideoId());
                    dto.setVideoDuration(content.getVideoDuration());
                    return dto;
                })
                .toList();
    }

    @Override
    public List<AssignmentDTO> getAssignmentsBulectureId(Integer lectureId) {
        return lectureAssignmentRepository.findByLecture_LectureId(lectureId).stream()
                .map(assignment -> {
                    AssignmentDTO dto = new AssignmentDTO();
                    dto.setAssignmentId(assignment.getAssignmentId());
                    dto.setTitle(assignment.getTitle());
                    dto.setDescription(assignment.getDescription());
                    dto.setStartDatetime(assignment.getStartDatetime());
                    dto.setEndDatetime(assignment.getEndDatetime());
                    dto.setSubmissionCount(assignment.getSubmissionCount());
                    dto.setLectureId(assignment.getLecture().getLectureId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentSubmitDTO getSubmitStatus(Integer assignmentId, Integer stdtId) {
        Optional<AssignmentSubmit> submitOpt = assignmentSubmitRepository.findByAssignment_AssignmentIdAndStudent_StdtId(assignmentId, stdtId);

        AssignmentSubmitDTO dto = new AssignmentSubmitDTO();

        if (submitOpt.isPresent()) {
            AssignmentSubmit submit = submitOpt.get();
            dto.setSubmitted(true);
            dto.setScore(submit.getScore());
            dto.setSubmissionType(submit.getSubmissionType());
            dto.setSubmissionDate(submit.getSubmissionDate());
        } else {
            dto.setSubmitted(false);
        }

        return dto;
    }

}


