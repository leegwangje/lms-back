package project.lmsback.controller.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import project.lmsback.domain.*;
import project.lmsback.service.MyCourserService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173", "http://172.30.1.58:3000"})
@Slf4j
@RestController
@RequestMapping("/api/mycourses") // ✅ 첫 번째 "mycourses"
@RequiredArgsConstructor
public class st_MyCoursesController {

    private final MyCourserService myCourserService;

    // 학생이 수강 중인 강의 목록 조회
    @GetMapping("/mycourses")
    public List<MycourseDTO> getMyCourses() {
        Integer stdtId = 20250001;
        List<MycourseDTO> courses = myCourserService.getCoursesByStudentId(stdtId);

        log.info("🎯 프론트에 전달될 강의 수: {}", courses.size());

        return courses;
    }

    // 특정 강의의 주차 목록 조회
    @GetMapping("/{lectureId}/weeks")
    public List<LectureWeekDTO> getWeeks(@PathVariable Integer lectureId) {
        return myCourserService.getWeeksByLectureId(lectureId);
    }

    // 특정 주차의 콘텐츠 목록 조회
    @GetMapping("/weeks/{weekId}/contents")
    public List<LectureContentDTO> getContents(@PathVariable Integer weekId) {
        return myCourserService.getContentsByWeekId(weekId);
    }

    @GetMapping("/{lectureId}/assignmnets")
    public List<AssignmentDTO> getAssignmnets(@PathVariable Integer lectureId) {
        return myCourserService.getAssignmentsBulectureId(lectureId);
    }
    @GetMapping("/assignments/{assignmentId}/submit")
    public AssignmentSubmitDTO getSubmitStatus(@PathVariable Integer assignmentId) {
        Integer stdtId = 20250001; // 로그인된 학생
        return myCourserService.getSubmitStatus(assignmentId, stdtId);
    }


}
