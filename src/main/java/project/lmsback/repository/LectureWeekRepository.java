package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.LectureWeek;

import java.util.List;

public interface LectureWeekRepository extends JpaRepository<LectureWeek, Integer> {
    List<LectureWeek> findByLecture_LectureId(Integer lectureId);
    LectureWeek findByLectureAndWeekId(LectureInfo lecture, Integer weekId);
}
