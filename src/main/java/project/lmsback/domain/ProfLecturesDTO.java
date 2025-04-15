package project.lmsback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfLecturesDTO {
    private Integer lectureId;
    private Integer semesterCd;
    private String department;
    private String subjectName;
    private String subjectLevel;
    private String gradeLevel;
    private Integer profId;
}
