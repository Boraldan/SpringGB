package boraldan.semi5hw1.repository;

import boraldan.semi5hw1.domen.Task;
import boraldan.semi5hw1.domen.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

//@Query("FROM Task t WHERE t.taskStatus = :taskStatus")
@Query("FROM Task t WHERE t.taskStatus = ?1")
List<Task> findByTaskStatus(@Param("taskStatus") TaskStatus status);
}
