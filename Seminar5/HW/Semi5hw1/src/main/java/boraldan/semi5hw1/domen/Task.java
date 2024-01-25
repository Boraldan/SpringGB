package boraldan.semi5hw1.domen;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false)
   private String title;

   @Enumerated(EnumType.STRING)
   @Column(name = "task_status")
   private TaskStatus taskStatus;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "creat_at")
   private LocalDateTime creatAt;

public Task setNullTask(){
    this.title = "Поле должно быть заполнено";
    return this;
}
    public Task notFindTask(){
        this.title = "Данного задания было удалено из базы";
        return this;
    }
}
