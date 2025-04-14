package project.lmsback.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.*;
import project.lmsback.repository.AttendanceRepository;
import project.lmsback.repository.FileRepository;
import project.lmsback.repository.LectureContentRepository;
import project.lmsback.repository.RegisterClassRepository;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final RegisterClassRepository registerClassRepository;
    private final LectureContentRepository lectureContentRepository;

    @Override
    public void markAttendance(Integer lectureId, Integer contentId, Integer stdtId) {
        log.info("🎯 출석 처리 로직 진입 - lectureId={}, contentId={}, stdtId={}", lectureId, contentId, stdtId);

        RegisterClass registerClass = registerClassRepository
                .findByLectureId_LectureIdAndStdtId_StdtId(lectureId, stdtId)
                .orElseThrow(() -> new RuntimeException("❌ 수강 정보를 찾을 수 없습니다."));

        LectureContent content = lectureContentRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("❌ 콘텐츠가 존재하지 않습니다."));

        boolean alreadyMarked = attendanceRepository
                .findByRegisterClassAndContent(registerClass, content)
                .isPresent();

        if (!alreadyMarked) {
            Attendance attendance = new Attendance();
            attendance.setRegisterClass(registerClass);
            attendance.setContent(content);
            attendance.setIsAttended(true);
            attendance.setAttendTime(LocalDateTime.now());
            attendanceRepository.save(attendance);

            log.info("✅ 출석 저장 완료!");
        } else {
            log.info("⛔ 이미 출석한 콘텐츠");
        }
    }
}
