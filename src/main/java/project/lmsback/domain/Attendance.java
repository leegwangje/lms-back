package project.lmsback.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ATTENDANCE")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id") // DB 컬럼명과 일치시킴
    private Integer attendanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTER_ID")
    private RegisterClass registerClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTENT_ID")
    private LectureContent content;

    @Column(name = "IS_ATTENDED")
    private Boolean isAttended;

    @Column(name = "ATTEND_TIME")
    private LocalDateTime attendTime;
}