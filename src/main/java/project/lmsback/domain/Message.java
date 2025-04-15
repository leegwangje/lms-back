package project.lmsback.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Message previousMessage;

    @Column(nullable = false)
    private int sender;

    @Column(nullable = false)
    private int receiver;

    @Column(nullable = false)
    private LocalDateTime sendDate;

    @Column(nullable = false)
    private LocalDateTime receiveDate;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String senderDeleted = "N";

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String receiverDeleted = "N";
}
