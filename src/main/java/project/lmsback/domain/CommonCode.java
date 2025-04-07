package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "COMMON_CODE")
public class CommonCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeGroup;
    private Integer code;
    private String codeName;

    // Getter/Setter
}
