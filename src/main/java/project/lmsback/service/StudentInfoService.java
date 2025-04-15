package project.lmsback.service;

import project.lmsback.domain.StudentProfileDTO;

import java.util.List;

public interface StudentInfoService {
    StudentProfileDTO stdtlist(Integer studentId);
}
