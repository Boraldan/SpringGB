package boraldan.semi5hw2.domen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Создайте сущность "проект" (Project), которая будет содержать следующие поля:
 * Идентификатор (id) типа Long, генерируемый автоматически при создании записи
 * Название проекта (name) типа String
 * Описание проекта (description) типа String
 * Дата создания (createdDate) типа LocalDate
 */

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> users = new ArrayList<>();

}
