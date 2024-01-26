package boraldan.semi5hw2.domen;

import jakarta.persistence.*;
import lombok.*;



/**
 * Создайте сущность "пользователи проекта" (UsersProject),
 * которая наследуется от класса "сущность с связью" и будет содержать следующие поля:
 * Идентификатор проекта (projectId) типа Long
 * Идентификатор пользователя (userId) типа Long
 */

//@Entity
//public class UsersProject  extends EntityWithRelation{
//    private Long projectId;
//    private Long userId;

@Data
@Entity
@Table(name = "user_project")
// аннотацию @IdClass, чтобы обозначить составной ключ  для JPA Repo
@IdClass(IdUserProject.class)
public class UsersProject {

    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Project project;





}
