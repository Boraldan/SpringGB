package boraldan.semi5hw2.service;

import boraldan.semi5hw2.domen.Project;
import boraldan.semi5hw2.domen.User;
import boraldan.semi5hw2.domen.UsersProject;
import boraldan.semi5hw2.repository.ProjectRepository;
import boraldan.semi5hw2.repository.UserRepository;
import boraldan.semi5hw2.repository.UsersProjectRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * public List getUsersByProjectId(Long projectId) - метод, возвращающий список пользователей, связанных с определенным проектом
 * public List getProjectsByUserId(Long userId) - метод, возвращающий список проектов, связанных с определенным пользователем
 * public void addUserToProject(Long userId, Long projectId) - метод, добавляющий пользователя к проекту
 * public void removeUserFromProject(Long userId, Long projectId) - метод, удаляющий пользователя из проекта
 */

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserProjectService {

    private final UserRepository userRepo;
    private final ProjectRepository projectRepo;


    public List<User> getUsersByProjectId(Long projectId) {
        Project project = projectRepo.findById(projectId).orElse(null);
        Hibernate.initialize(project.getUsers());
        return project.getUsers();
    }

    public List<Project> getProjectsByUserId(Long userId) {
        User user = userRepo.findById(userId).orElse(null);
        Hibernate.initialize(user.getProjects());
        return user.getProjects();
    }

    @Transactional
    public void addUserToProject(Long userId, Long projectId) {
        Project project = projectRepo.findById(projectId).orElse(null);
        User user = userRepo.findById(userId).orElse(null);
        project.getUsers().add(user);
        projectRepo.save(project);
    }

    @Transactional
    public void removeUserFromProject(Long userId, Long projectId) {
        Project project = projectRepo.findById(projectId).orElse(null);
        User user = userRepo.findById(userId).orElse(null);
        project.getUsers().remove(user);
        projectRepo.save(project);
    }

    @Transactional
    public User newUser(User user) {
        return userRepo.save(user);
    }

    @Transactional
    public Project newProject(Project project) {
        project.setCreatedDate(LocalDate.now());
        return projectRepo.save(project);
    }

}
