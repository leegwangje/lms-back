package project.lmsback.domain;

import lombok.Data;

@Data
public class LectureContentDTO {

    private Integer lectureManagementId;
    private String chapterName;
    private String orderName;
    private String youtubeVideoId;
    private String videoDuration;
    private Integer fileId;
    private String fileName;
    private Integer lectureId;
}
