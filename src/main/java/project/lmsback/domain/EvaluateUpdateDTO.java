package project.lmsback.domain;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluateUpdateDTO {
    private int assignmentId;
    private Integer stdt_id;
    private String stdt_name;
    private String assignment_name;
    private Integer lectureId;
    private Integer fileId;
    private Integer score;
    private String fileName;
}

