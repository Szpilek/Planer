package app.planer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    String name;
    TaskState taskState;
    TaskImportance taskImportance;
    LocalDate createdDate;
}
