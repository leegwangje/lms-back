package project.lmsback.controller.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.lmsback.domain.Attendance;
import project.lmsback.domain.AttendanceRequestDto;
import project.lmsback.service.AttendanceService;

@CrossOrigin(origins = {"http://localhost:3000", "http://172.30.1.58:3000"})
@Slf4j
@RestController
@RequestMapping("/api/video") // ✅ 첫 번째 "mycourses"
@RequiredArgsConstructor
public class st_AttendanceController {


    private final AttendanceService attendanceService;

    @PostMapping("/attendance")
    public ResponseEntity<String> markAttendance(@RequestBody AttendanceRequestDto dto) {
        log.info("📡 출석 요청 도착: lectureId={}, contentId={}, stdtId={}",
                dto.getLectureId(), dto.getContentId(), dto.getStdtId());

        attendanceService.markAttendance(dto.getLectureId(), dto.getContentId(), dto.getStdtId());
        return ResponseEntity.ok("출석 처리 완료");
    }

}
