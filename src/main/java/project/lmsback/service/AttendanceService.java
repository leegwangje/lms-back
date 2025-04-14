package project.lmsback.service;

import project.lmsback.domain.AttendanceRequestDto;
public interface AttendanceService {
    void markAttendance(Integer lectureId, Integer contentId, Integer stdtId);
}
