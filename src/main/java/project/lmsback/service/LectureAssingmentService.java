package project.lmsback.service;

import org.springframework.web.multipart.MultipartFile;
import project.lmsback.domain.AssignmentDTO;
import project.lmsback.domain.AssignmentUploadDTO;
import project.lmsback.domain.File;
import project.lmsback.domain.LectureAssignment;

import java.util.List;

public interface LectureAssingmentService {
    LectureAssignment assignmentUpload(AssignmentUploadDTO dto, MultipartFile file);
    List<AssignmentDTO> findByLectureAssignment(Integer profId);
}
