package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import project.lmsback.domain.AssignmentSubmit;

import java.util.List;
import java.util.Optional;

public interface AssignmentSubmitRepository extends JpaRepository<AssignmentSubmit, Integer> {
    Optional<AssignmentSubmit> findByAssignment_AssignmentIdAndStudent_StdtId(Integer assignmentId, Integer stdtId);
    int countByLecture_LectureIdAndStudent_StdtId(Integer lectureId, Integer stdtId);
    List<AssignmentSubmit> findByLecture_LectureId(Integer lectureId);
    AssignmentSubmit findByAssignment_AssignmentIdAndStudent_stdtId(Integer assignmentId, Integer stdtId);

    @Modifying
    @Query("update AssignmentSubmit set score = :score where assignmentSubmitId = :assignmentId")
    int updateViews(Integer assignmentId, Integer score);


}
