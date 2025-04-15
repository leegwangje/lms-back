package project.lmsback.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LectureFileUploadDTO {
    private String subject_name;
    private String chapter;
    private String videoId;
    private Integer profid;
    private Integer lecture_id;
}
