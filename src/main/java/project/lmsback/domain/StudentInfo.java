package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "STDT_INFO")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stdtId;

    private String stdtName;
    private Integer genCd;
    private String hpNo;
    private String addrDtl;
    private String zip;
    private String addr;
    private String email;
    private String major;
    private String stdtBirth;
    private String entryYear;
    private String password;
    private Integer stateCd;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    // Getter/Setter
}
