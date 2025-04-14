package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.StudentInfo;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentInfo, Integer> {
    StudentInfo findByStdtId(Integer studentId);
}
