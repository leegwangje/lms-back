package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "ADMIN")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    private String adminName;
    private String hpNo;
    private String addr;
    private String addrDtl;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    // Getter/Setter
}
