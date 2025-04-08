package project.lmsback.domain;

import lombok.Data;

@Data
public class AssignmentDTO {

    private Integer assignmentId;
    private String title;
    private String description;
    private String startDatetime;
    private String endDatetime;
    private Integer submissionCount;
    private Integer lectureId;


}

