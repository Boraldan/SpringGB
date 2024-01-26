package boraldan.semi5hw2.controller;


import boraldan.semi5hw2.domen.Project;
import boraldan.semi5hw2.domen.User;
import boraldan.semi5hw2.service.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * public ResponseEntity<List> getUsersByProjectId(Long projectId) - метод, обрабатывающий GET-запрос для получения списка пользователей, связанных с определенным проектом
 * public ResponseEntity<List> getProjectsByUserId(Long userId) - метод, обрабатывающий GET-запрос для получения списка проектов, связанных с определенным пользователем
 * public ResponseEntity addUserToProject(Long userId, Long projectId) - метод, обрабатывающий POST-запрос для добавления пользователя к проекту
 * public ResponseEntity removeUserFromProject(Long userId, Long projectId) - метод, обрабатывающий POST-запрос для удаления пользователя из проекта
 */

@RestController
@AllArgsConstructor
public class UserProjectController {

    private final UserProjectService userProjectService;

    @GetMapping("/users/{projectId}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok(userProjectService.getUsersByProjectId(projectId));
    }

    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userProjectService.getProjectsByUserId(userId));
    }

    @PostMapping("/add")
    public ResponseEntity addUserToProject(@RequestParam Long userId,
                                           @RequestParam Long projectId) {
        userProjectService.addUserToProject(userId, projectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove")
    public ResponseEntity removeUserFromProject(@RequestParam Long userId, @RequestParam Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/new")
    public ResponseEntity<User> newUser(@RequestBody User user){
      return  ResponseEntity.ok(userProjectService.newUser(user));
    }

    @PostMapping("/projects/new")
    public ResponseEntity<Project> newProject(@RequestBody Project project){
        return ResponseEntity.ok(userProjectService.newProject(project));
    }
}
