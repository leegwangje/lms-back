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
    private LectureInfo lecture;

    @ManyToOne
    @JoinColumn(name = "STDT_ID")
    private StudentInfo student;

    @Column(name = "APPLY_DATE")
    private String applyDate;

    @Column(name = "ATTENDANCE_RATE")
    private Integer attendanceRate;

    @Column(name = "ATTENDANCE_SCORE")
    private Integer attendanceScore;

    @Column(name = "ASSIGNMENT_SCORE")
    private Integer assignmentScore;

    @Column(name = "PERCENTILE_SCORE")
    private Integer percentileScore;

    @Column(name = "GRADE_EVALUATION")
    private String gradeEvaluation;

    @Column(name = "GPA_SCORE")
    private String gpaScore;

    // Getter/Setter
}
