package project.lmsback.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ASSIGNMENT_SUBMIT")
public class AssignmentSubmit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assignmentSubmitId;

    @Column(name = "SUBMISSION_TYPE")
    private String submissionType;

    @Column(name = "SUBMISSION_DATE")
    private String submissionDate;

    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNMENT_ID")
    private LectureAssignment assignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    private File file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LECTURE_ID")
    private LectureInfo lecture;

    // ✅ 추가: 학생 정보 연결 (이게 없어서 오류났음)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STDT_ID")
    private StudentInfo student;


    public void setStdtId(Integer stdtId) {
    }
}
