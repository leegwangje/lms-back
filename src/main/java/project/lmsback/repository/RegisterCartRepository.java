package project.lmsback.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.lmsback.domain.*;

import java.util.List;
import java.util.Optional;

public interface RegisterCartRepository extends JpaRepository<RegisterCart, Integer> {

    // 장바구니 중복 확인
    Optional<RegisterCart> findByStudentAndLecture(StudentInfo student, LectureInfo lecture);

   // 기존 장바구니 항목을 찾는 쿼리
    Optional<RegisterCart> findByLecture_LectureIdAndStudent_StdtId(Integer lectureId, Integer stdtId);

    // 장바구니 목록 조회 (DTO 매핑)
    @Query("SELECT new project.lmsback.domain.RegisterCartDTO(" +
            "c.student.stdtId, " +
            "c.lecture.lectureId, " +
            "c.priorityOrder, " +         // 우선순위
            "c.lecture.courseType, " +    // 이수구분
            "c.lecture.department, " +    // 개설전공학과
            "c.lecture.subjectCode, " +   // 교과목코드
            "c.lecture.subjectName, " +   // 교과목명
            "c.lecture.subjectLevel, " +  // 교과목 수준
            "c.lecture.credit, " +        // 학점
            "c.lecture.timetable) " +     // 시간표
            "FROM RegisterCart c " +
            "WHERE c.student.stdtId = :stdtId " +
            "ORDER BY CASE WHEN c.priorityOrder IS NULL THEN 1 ELSE 0 END, c.priorityOrder ASC")

    List<RegisterCartDTO> findCartDTOByStdtId(@Param("stdtId") Integer stdtId);


    // 강의 정보만 DTO로 한방에 가져오기 (LectureDTO)
    @Query("SELECT new project.lmsback.domain.LectureDTO(l.lectureId, l.courseType, l.department, l.subjectCode, l.subjectName, l.subjectLevel, l.credit, l.timetable) " +
            "FROM RegisterCart c JOIN c.lecture l " +
            "WHERE c.student.stdtId = :stdtId " +
            "ORDER BY CASE WHEN c.priorityOrder IS NULL THEN 1 ELSE 0 END, c.priorityOrder ASC")
    List<LectureDTO> findLectureDTOsInCartByStdtId(@Param("stdtId") Integer stdtId);

}

