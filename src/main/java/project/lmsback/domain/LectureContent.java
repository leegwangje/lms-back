package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "LECTURE_CONTENT")
public class LectureContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lectureManagementId;

    @Column(name = "YOUTUBE_VIDEO_ID")
    private String youtubeVideoId;

    @Column(name = "LECTURE_CALL_URL")
    private String lectureCallUrl;

    @Column(name = "ONLINE_STATUS_TYPE")
    private String onlineStatusType;

    @Column(name = "CHAPTER_NAME")
    private String chapterName;

    @Column(name = "ORDER_NAME")
    private String orderName;

    @ManyToOne
    @JoinColumn(name = "WEEK_ID")
    private LectureWeek week;

    @Column(name = "VIDEO_DURATION")
    private String videoDuration;

    @ManyToOne
    @JoinColumn(name = "FILE_ID")
    private File file;

    // Getter/Setter
}
