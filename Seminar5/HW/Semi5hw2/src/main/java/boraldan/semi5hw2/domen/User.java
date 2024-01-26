package boraldan.semi5hw2.domen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Идентификатор (id) типа Long, генерируемый автоматически при создании записи
 * Имя пользователя (username) типа String
 * Пароль (password) типа String
 * Электронная почта (email) типа String
 * Роль (role) типа String
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    public List<Project> projects = new ArrayList<>();

}
