package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.LectureContent;
import project.lmsback.domain.LectureWeek;

import java.util.List;

public interface LectureContentRepository extends JpaRepository<LectureContent, Integer> {
    List<LectureContent> findByWeek_WeekId(Integer weekId);
    List<LectureContent> findByLecture_LectureId(Integer lectureId);
}
