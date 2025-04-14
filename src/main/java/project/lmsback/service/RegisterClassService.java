package project.lmsback.service;

import project.lmsback.domain.StudentProfileDTO;

import java.util.List;

public interface RegisterClassService {
    List<StudentProfileDTO> classUserList(Integer lectureId);
    List<StudentProfileDTO> classMassageList(Integer lectureId);
}
