package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.LectureContent;
import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.LectureListDTO;
import project.lmsback.domain.LectureWeek;
import project.lmsback.repository.FileRepository;
import project.lmsback.repository.LectureContentRepository;
import project.lmsback.repository.LectureInfoRepository;
import project.lmsback.repository.LectureWeekRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureInfoServiceImpl implements LectureInfoService {

    private final LectureInfoRepository lectureInfoRepository;
    private final LectureWeekRepository lectureWeekRepository;//week 테이블 포함되있음
    private final LectureContentRepository lectureContentRepository;//file 테이블 포함되있음

    @Override
    public List<LectureInfo> findByLecture_profId(Integer profId) {
        List<LectureInfo> list = lectureInfoRepository.findByProfessor_ProfId(profId);
        return list;
    }

    @Override
    public List<LectureListDTO> lectureList(Integer lectureId) {
        List<LectureWeek> weeks = lectureWeekRepository.findByLecture_LectureId(lectureId);
        List<LectureContent> contents = lectureContentRepository.findByLecture_LectureId(lectureId);

        List<LectureListDTO> dtoList = new ArrayList<>();

        for (LectureWeek week : weeks) {
            for (LectureContent content : contents) {
                if (content.getWeek().getWeekId().equals(week.getWeekId())) {
                    LectureListDTO dto = new LectureListDTO();

                    dto.setWeekId(week.getWeekId());
                    dto.setOrder_name(content.getOrderName());
                    dto.setFile_id(content.getFile().getFileId());
                    dto.setFile_name(content.getFile().getFileName());
                    dto.setUuid(content.getFile().getUuid());
                    dto.setSubject_name(week.getLecture().getSubjectName());
                    dto.setSubject_plan(content.getLecture().getSubjectPlan());
                    dto.setSemester_cd(week.getLecture().getSemesterCd());

                    dtoList.add(dto);

                    log.info("dto :: {}", dto.toString());
                }
            }
        }
        log.info("dtoList :: {}", dtoList.toString());

        return dtoList;
    }

}
