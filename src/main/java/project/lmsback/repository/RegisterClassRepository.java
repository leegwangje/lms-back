package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.RegisterClass;

import java.util.List;
import java.util.Optional;


public interface RegisterClassRepository extends JpaRepository<RegisterClass, Integer> {
    // StudentInfo 엔티티와 연결된 stdtId로 수강 강좌를 조회
    List<RegisterClass> findByStdtId_StdtId(Integer stdtId);

    Optional<RegisterClass> findByLectureId_LectureIdAndStdtId_StdtId(Integer lectureId, Integer stdtId);

    List<RegisterClass> findByLectureId_LectureId(Integer lectureId);

}
