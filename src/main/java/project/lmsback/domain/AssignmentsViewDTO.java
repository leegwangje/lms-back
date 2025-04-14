package project.lmsback.domain;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentsViewDTO {
    private int assignmentId;
    private int stdt_id;
    private String stdt_name;
    private String assignment_name;
    private String submissionDate;
    private String fileName;
    private int score;
    private String uuid;
}
