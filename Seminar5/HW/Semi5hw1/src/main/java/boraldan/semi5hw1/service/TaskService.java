package boraldan.semi5hw1.service;

import boraldan.semi5hw1.domen.Task;
import boraldan.semi5hw1.domen.TaskStatus;
import boraldan.semi5hw1.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepo;

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task addTask(Task task) {
        task.setTaskStatus(TaskStatus.NOT_STARTED);
        task.setCreatAt(LocalDateTime.now());
        return taskRepo.save(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepo.findByTaskStatus(status);
    }

    public Task updateTaskStatus(Long id, Task task) {
        Task dbTask = taskRepo.findById(id).orElse(null);
        if (dbTask == null) {
            return new Task().notFindTask();
        }
        if (task.getTitle() != null) {
            dbTask.setTitle(task.getTitle());
        }
        if (!task.getTaskStatus().equals(dbTask.getTaskStatus())) {
            dbTask.setTaskStatus(task.getTaskStatus());
        }
        return taskRepo.save(dbTask);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
