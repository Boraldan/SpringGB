package boraldan.semi5hw2.repository;

import boraldan.semi5hw2.domen.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long> {


}
