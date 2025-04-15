package project.lmsback.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.lmsback.domain.LectureContent;
import project.lmsback.domain.LectureFileUploadDTO;
import project.lmsback.domain.LectureWeek;

import java.util.List;

public interface LectureContentRepository extends JpaRepository<LectureContent, Integer> {
    List<LectureContent> findByWeek_WeekId(Integer weekId);
    LectureContent findByLecture_LectureIdAndOrderName(Integer lectureId, String name);

    List<LectureContent> findByLecture_LectureId(Integer lectureId);

    @Query("SELECT c FROM LectureContent c WHERE c.lecture.lectureId = :lectureId AND c.week.weekId = :weekId")
    List<LectureContent> findByLectureIdAndWeekId(@Param("lectureId") Integer lectureId, @Param("weekId") Integer weekId);


    List<LectureContent> findByLecture_LectureIdAndWeek_WeekId(Integer lectureId, Integer weekId);


}
