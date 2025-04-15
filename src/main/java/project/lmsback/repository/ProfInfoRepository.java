package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.ProfInfo;

import java.util.Optional;

public interface ProfInfoRepository extends JpaRepository<ProfInfo, Integer> {
    Optional<ProfInfo> findByProfId(int profId);


}
