package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.AssignmentSubmit;
import java.util.Optional;

public interface AssignmentSubmitRepository extends JpaRepository<AssignmentSubmit, Integer> {
    Optional<AssignmentSubmit> findByAssignment_AssignmentIdAndStudent_StdtId(Integer assignmentId, Integer stdtId);
}
