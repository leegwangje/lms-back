package project.lmsback.controller.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import project.lmsback.domain.MycourseDTO;
import project.lmsback.service.MyCourserService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173", "http://172.30.1.58:3000"})
@Slf4j
@RestController
@RequestMapping("/api/mycourses") // ✅ 첫 번째 "mycourses"
@RequiredArgsConstructor
public class st_MyCoursesController {

    private final MyCourserService myCourserService;

    @GetMapping("/mycourses")
    public List<MycourseDTO> getMyCourses() {
        Integer stdtId = 20250001;
        List<MycourseDTO> courses = myCourserService.getCoursesByStudentId(stdtId);

        log.info("🎯 프론트에 전달될 강의 수: {}", courses.size());

        return courses;
    }
}
