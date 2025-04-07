package project.lmsback.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LECTURE_INFO")
public class LectureInfo {

    // ✅ Getter & Setter
    @Id
    @Column(name = "LECTURE_ID")
    private Integer lectureId;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "DEPARTMENT")
    private String department;

    // 🔧 기타 필드 필요하면 여기 추가

}
