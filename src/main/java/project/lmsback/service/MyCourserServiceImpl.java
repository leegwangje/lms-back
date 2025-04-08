package project.lmsback.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.*;
import project.lmsback.repository.LectureContentRepository;
import project.lmsback.repository.LectureWeekRepository;
import project.lmsback.repository.RegisterClassRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyCourserServiceImpl implements MyCourserService {
    private final RegisterClassRepository registerClassRepository;
    private final LectureWeekRepository lectureWeekRepository;
    private final LectureContentRepository lectureContentRepository;

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
}


