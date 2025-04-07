package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "PARENT_POST_ID")
    private Integer parentPostId;

    private String title;
    private String content;
    private String writer;
    private String createdAt;
    private String isSecret;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private BoardInfo board;

    @ManyToOne
    @JoinColumn(name = "PREV_POST_ID")
    private Post prevPost;

    @ManyToOne
    @JoinColumn(name = "FILE_ID")
    private File file;

    // Getter/Setter
}
