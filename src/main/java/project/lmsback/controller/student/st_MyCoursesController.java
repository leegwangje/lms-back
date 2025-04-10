package project.lmsback.controller.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.lmsback.domain.*;
import project.lmsback.service.MyCourserService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://172.30.1.58:3000"})
@Slf4j
@RestController
@RequestMapping("/api/mycourses") // ✅ 첫 번째 "mycourses"
@RequiredArgsConstructor
public class st_MyCoursesController {

    private final MyCourserService myCourserService;

    // 학생이 수강 중인 강의 목록 조회
    @GetMapping("/mycourses")
    public List<MycourseDTO> getMyCourses(@RequestParam Integer stdtId) {

        List<MycourseDTO> courses = myCourserService.getCoursesByStudentId(stdtId);

        log.info("🎯 프론트에 전달될 강의 수: {}", courses.size());

        return courses;
    }

    // 특정 강의의 주차 목록 조회
    @GetMapping("/{lectureId}/weeks")
    public List<LectureWeekDTO> getWeeks(@PathVariable Integer lectureId) {
        return myCourserService.getWeeksByLectureId(lectureId);
    }

//    // 특정 주차의 콘텐츠 목록 조회
//    @GetMapping("/weeks/{weekId}/contents")
//    public List<LectureContentDTO> getContents(@PathVariable Integer weekId) {
//        return myCourserService.getContentsByWeekId(weekId);
//    }

    // 특정 강의와 주차의 콘텐츠 목록 조회
    @GetMapping("/{lectureId}/week/{weekNumber}/contents")
    public List<LectureContentDTO> getContentsByLectureAndWeek(
            @PathVariable Integer lectureId,
            @PathVariable Integer weekNumber) {
        return myCourserService.getContentsByLectureAndWeek(lectureId, weekNumber);
    }

    @GetMapping("/{lectureId}/assignments")
    public List<AssignmentDTO> getAssignments(@PathVariable Integer lectureId) {
        return myCourserService.getAssignmentsByLectureId(lectureId);
    }
    @GetMapping("/assignments/{assignmentId}/submit")
    public AssignmentSubmitDTO getSubmitStatus(@PathVariable Integer assignmentId) {
        Integer stdtId = 20250001; // 로그인된 학생
        return myCourserService.getSubmitStatus(assignmentId, stdtId);
    }

//    // 특정 주차(weekId)의 과제 정보 반환
//    @GetMapping("/weeks/{weekId}/assignment")
//    public ResponseEntity<AssignmentDTO> getAssignmentByWeek(@PathVariable Integer weekId) {
//        AssignmentDTO assignment = myCourserService.getAssignmentByWeekId(weekId);
//        return ResponseEntity.ok(assignment);
//    }

    @GetMapping("/{lectureId}/week/{weekNumber}/assignment")
    public ResponseEntity<AssignmentDTO> getAssignmentByLectureAndWeek(
            @PathVariable Integer lectureId,
            @PathVariable Integer weekNumber
    ) {
        AssignmentDTO assignment = myCourserService.getAssignmentByLectureAndWeek(lectureId, weekNumber);
        return ResponseEntity.ok(assignment);
    }




    //
    @PostMapping("/submit")
    public ResponseEntity<String> submitAssignment(
            @RequestParam("file") MultipartFile file,
            @RequestParam("lectureId") Integer lectureId,
            @RequestParam("weekNumber") Integer weekNumber,
            @RequestParam("stdtId") Integer stdtId
    ) {
        myCourserService.saveAssignmentSubmit(file, lectureId, weekNumber, stdtId);
        return ResponseEntity.ok("제출 완료");
    }




}
