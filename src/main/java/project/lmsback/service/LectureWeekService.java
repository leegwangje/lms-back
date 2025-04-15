package project.lmsback.service;

import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.LectureWeek;

public interface LectureWeekService {
    LectureWeek findByLectureAndWeekId(LectureInfo lecture, Integer weekNumber);
}
