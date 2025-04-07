package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "LECTURE_PROGRESS")
public class LectureProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer progressId;

    @Column(name = "WATCH_TIME_TOTAL")
    private String watchTimeTotal;

    @Column(name = "WATCH_STATE")
    private String watchState;

    @Column(name = "LAST_WATCH_TIME")
    private String lastWatchTime;

    @Column(name = "LECTURE_NAME")
    private String lectureName;

    @Column(name = "CONTENT_ID")
    private String contentId;

    @Column(name = "WATCH_LIMIT")
    private String watchLimit;

    @Column(name = "PROGRESS_RATE")
    private Double progressRate;

    @ManyToOne
    @JoinColumn(name = "STDT_ID")
    private StudentInfo student;

    @Column(name = "FINAL_PLAYED_TIME")
    private Integer finalPlayedTime;

    @Column(name = "MAX_PLAY_TIME")
    private Integer maxPlayTime;

    @ManyToOne
    @JoinColumn(name = "LECTURE_MANAGEMENT_ID")
    private LectureContent lectureContent;

    // Getter/Setter
}
