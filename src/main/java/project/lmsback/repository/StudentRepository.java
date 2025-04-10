package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.StudentInfo;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentInfo, Integer> {
    Optional<StudentInfo> findByStdtId(int stdtId);



}
