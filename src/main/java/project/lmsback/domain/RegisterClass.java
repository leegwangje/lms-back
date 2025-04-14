package project.lmsback.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "REGISTER_CLASS")
public class RegisterClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registerId;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private LectureInfo lectureId;

    @ManyToOne
    @JoinColumn(name = "STDT_ID")
    private StudentInfo stdtId;

    @Column(name = "APPLY_DATE")
    private String applyDate;

    @Column(name = "ATTENDANCE_RATE")
    private Integer attendanceRate=0;

    @Column(name = "ATTENDANCE_SCORE")
    private Integer attendanceScore=0;

    @Column(name = "ASSIGNMENT_SCORE")
    private Integer assignmentScore=0;

    @Column(name = "PERCENTILE_SCORE")
    private Integer percentileScore=0;

    @Column(name = "GRADE_EVALUATION")
    private String gradeEvaluation="F";

    @Column(name = "GPA_SCORE")
    private Double gpaScore=0.0;

    // Getter/Setter
}