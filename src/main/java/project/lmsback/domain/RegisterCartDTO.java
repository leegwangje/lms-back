package project.lmsback.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class RegisterCartDTO {

    private Integer stdtId;
    private Integer lectureId;
    private Integer priorityOrder;

    private String courseType;
    private String department;
    private String subjectCode;
    private String subjectName;
    private String subjectLevel;
    private String credit;     // ✅ 여기!
    private String timetable;

    public RegisterCartDTO(Integer stdtId, Integer lectureId, Integer priorityOrder,
                           String courseType, String department, String subjectCode,
                           String subjectName, String subjectLevel, String credit, String timetable) {
        this.stdtId = stdtId;
        this.lectureId = lectureId;
        this.priorityOrder = priorityOrder;
        this.courseType = courseType;
        this.department = department;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.subjectLevel = subjectLevel;
        this.credit = credit;
        this.timetable = timetable;
    }
}
