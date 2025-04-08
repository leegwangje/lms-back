package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.LectureAssignment;

import java.util.List;

public interface LectureAssignmentRepository extends JpaRepository<LectureAssignment, Integer> {
    List<LectureAssignment> findByLecture_LectureId(Integer lectureId);
}
