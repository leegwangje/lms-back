package project.lmsback.domain;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "ASSIGNMENT_ID")
    private LectureAssignment assignment;

    @ManyToOne
    @JoinColumn(name = "FILE_ID")
    private File file;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private LectureInfo lecture;

    // Getter/Setter
}
