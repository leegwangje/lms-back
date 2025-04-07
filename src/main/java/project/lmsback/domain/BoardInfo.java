package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "BOARD_INFO")
public class BoardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId;

    @Column(name = "BOARD_TYPE")
    private String boardType;

    @Column(name = "BOARD_NAME")
    private String boardName;

    @Column(name = "USE_YN")
    private String useYn;

    // Getter/Setter
}
