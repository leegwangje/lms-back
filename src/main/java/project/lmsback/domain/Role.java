package project.lmsback.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;

    // Getter/Setter
}
