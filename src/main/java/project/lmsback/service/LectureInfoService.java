package project.lmsback.service;

import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.LectureListsDTO;
import project.lmsback.domain.ProfLecturesDTO;

import java.util.List;

public interface LectureInfoService {
    List<ProfLecturesDTO> findByLecture_profId(Integer profId);
    List<LectureListsDTO> lectureList(Integer lectureId);
    List<LectureListsDTO> listLecture(Integer profId);
    LectureInfo findByLectureId(Integer lectureId);
}
