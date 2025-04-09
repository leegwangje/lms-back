package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.LectureListDTO;
import project.lmsback.domain.LectureWeek;
import project.lmsback.repository.LectureInfoRepository;

import java.util.List;

public interface LectureInfoService {
    List<LectureInfo> findByLecture_profId(Integer profId);
    List<LectureListDTO> lectureList(Integer lectureId);
}
