package boraldan.semi5hw2.repository;

import boraldan.semi5hw2.domen.IdUserProject;
import boraldan.semi5hw2.domen.User;
import boraldan.semi5hw2.domen.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, IdUserProject> {

}
