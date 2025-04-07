package project.lmsback.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.RegisterClass;
import java.util.List;


public interface RegisterClassRepository extends JpaRepository<RegisterClass, Integer> {
    List<RegisterClass> findByStdtId(Integer stdtId);

}
