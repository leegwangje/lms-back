package project.lmsback.domain;

import lombok.Data;

@Data
public class AssignmentSubmitDTO {
    private boolean submitted;
    private Integer score;
    private String submissionType;
    private String submissionDate;


}
