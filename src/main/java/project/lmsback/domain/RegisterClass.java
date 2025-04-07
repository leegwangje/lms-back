package project.lmsback.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "REGISTER_CLASS")
public class RegisterClass {

    @Id
    @Column(name = "REGISTER_ID")
    private Integer registerId;

    // ✅ 필드명이 반드시 "stdtId" 여야 함
    @Column(name = "STDT_ID")
    private Integer stdtId;

    @Column(name = "APPLY_DATE")
    private LocalDateTime applyDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LECTURE_ID")
    private LectureInfo lecture;

}
