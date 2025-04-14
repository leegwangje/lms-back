package project.lmsback.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AssignmentUploadDTO {
    private Integer assignmentId;
    private Integer week_id;
    private String title;
    private String description;
    private String startDatetime;
    private String endDatetime;
    private Integer submissionCount;
    private Integer lecture_id;
}

