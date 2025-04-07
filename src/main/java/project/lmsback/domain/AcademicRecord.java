package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "ACADEMIC_RECORD")
public class AcademicRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    private String courseYear;
    private String creditApplied;
    private String creditEarned;
    private String gradePercentage;
    private String termAvgScore;
    private String termRankScore;
    private String gradeAvgScore;
    private String termAvgGrade;
    private String gradeEvalCount;
    private String jointMajorCredit;
    private String jointMinorCredit;
    private String retakenCreditCount;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private LectureInfo lecture;

    private Integer semesterCd;

    // Getter/Setter
}
