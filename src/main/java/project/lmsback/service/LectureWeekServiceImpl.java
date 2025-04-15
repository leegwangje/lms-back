package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.LectureWeek;
import project.lmsback.repository.LectureWeekRepository;

@Service
@RequiredArgsConstructor
public class LectureWeekServiceImpl implements LectureWeekService {
    private final LectureWeekRepository lectureWeekRepository;

    @Override
    public LectureWeek findByLectureAndWeekId(LectureInfo lecture, Integer weekNumber) {
        return lectureWeekRepository.findByLectureAndWeekId(lecture, weekNumber);
    }
}
