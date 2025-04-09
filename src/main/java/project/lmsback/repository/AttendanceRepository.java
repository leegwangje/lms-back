package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.Attendance;
import project.lmsback.domain.LectureContent;
import project.lmsback.domain.RegisterClass;

import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    Optional<Attendance> findByRegisterClassAndContent(RegisterClass registerClass, LectureContent content);

}
