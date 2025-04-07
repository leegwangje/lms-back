package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "LECTURE_ASSIGNMENT")
public class LectureAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assignmentId;

    private String title;
    private String description;
    private String startDatetime;
    private String endDatetime;
    private Integer submissionCount;

    @ManyToOne
    @JoinColumn(name = "FILE_ID")
    private File file;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private LectureInfo lecture;

    // Getter/Setter
}
