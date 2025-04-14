package project.lmsback.service;

import project.lmsback.domain.File;
import project.lmsback.domain.LectureContent;
import project.lmsback.domain.LectureFileUploadDTO;

import java.util.List;

public interface LectureContentService {
    LectureContent lectureUpdateFile(LectureFileUploadDTO dto, File file);
    List<LectureContent> findLectureId(Integer lectureId);
}
