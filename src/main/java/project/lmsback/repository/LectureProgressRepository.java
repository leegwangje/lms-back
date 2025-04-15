package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.LectureProgress;

import java.util.List;

public interface LectureProgressRepository extends JpaRepository<LectureProgress, Integer> {
}
