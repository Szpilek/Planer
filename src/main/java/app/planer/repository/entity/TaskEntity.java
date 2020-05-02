package app.planer.repository.entity;

import app.planer.model.TaskImportance;
import app.planer.model.TaskState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskEntity {
    @GeneratedValue
    @Id
    Integer id;
    String name;
    TaskState taskState;
    TaskImportance taskImportance;
    LocalDate createdDate;
}
