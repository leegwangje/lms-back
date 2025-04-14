package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.ProfLecturesDTO;

import java.util.List;

public interface LectureInfoRepository extends JpaRepository<LectureInfo, Integer> {
    List<LectureInfo> findByProfessor_ProfId(int profId);
    LectureInfo findByLectureId(Integer lectureId);

}