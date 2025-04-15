package project.lmsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lmsback.domain.File;

public interface FileRepository  extends JpaRepository<File, Integer> {
    File save(File file);
}
