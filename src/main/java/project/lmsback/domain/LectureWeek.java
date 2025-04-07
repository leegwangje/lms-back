package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "LECTURE_WEEK")
public class LectureWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weekId;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private LectureInfo lecture;

    // Getter/Setter
}