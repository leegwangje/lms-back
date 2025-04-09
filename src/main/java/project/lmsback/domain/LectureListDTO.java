package project.lmsback.domain;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LectureListDTO {
    private Integer weekId;//lectureweek
    private String order_name;//LECTURE_CONTENT
    private Integer file_id;//LECTURE_CONTENT
    private String file_name;//FILE
    private String uuid;//FILE
    private String subject_plan;//lectureweek
    private String subject_name;//lectureweek
    private Integer semester_cd;//lectureweek
}
