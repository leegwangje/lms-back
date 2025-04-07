package project.lmsback.domain;

import javax.persistence.*;

@Entity
@Table(name = "FILE")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId;

    @Column(name = "FILE_ORG_ID")
    private Integer fileOrgId;

    private String uuid;
    private String fileName;
    private String filePath;
    private Integer fileSize;

    // Getter/Setter
}
