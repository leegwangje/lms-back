package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private String content;
    private String writer;
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "PARENT_COMMENT_ID")
    private Comment parentComment;

    // Getter/Setter
}
