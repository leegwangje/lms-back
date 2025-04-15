package project.lmsback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentProfileDTO {
    private Integer profId;
    private Integer lectureId;
    private Integer stdtId;
    private String stdtName;
    private String email;
    private String major;
    private String hpNo;
    private Double progressRate;
    private Double submissionRate;
}
