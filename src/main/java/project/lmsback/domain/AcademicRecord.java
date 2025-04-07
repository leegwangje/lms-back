package project.lmsback.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "academic_record")
public class AcademicRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "course_year")
    private String courseYear;

    @Column(name = "credit_applied")
    private String creditApplied;

    @Column(name = "credit_earned")
    private String creditEarned;

    @Column(name = "grade_avg_score")
    private String gradeAvgScore;

    @Column(name = "grade_eval_count")
    private String gradeEvalCount;

    @Column(name = "grade_percentage")
    private String gradePercentage;

    @Column(name = "joint_major_credit")
    private String jointMajorCredit;

    @Column(name = "joint_minor_credit")
    private String jointMinorCredit;

    @Column(name = "retaken_credit_count")
    private String retakenCreditCount;

    @Column(name = "semester_cd")
    private Integer semesterCd;

    @Column(name = "term_avg_grade")
    private String termAvgGrade;

    @Column(name = "term_avg_score")
    private String termAvgScore;

    @Column(name = "term_rank_score")
    private String termRankScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private LectureInfo lecture;
}
