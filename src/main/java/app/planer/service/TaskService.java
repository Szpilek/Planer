package app.planer.service;

import app.planer.model.Note;
import app.planer.model.Task;
import app.planer.repository.NoteRepository;
import app.planer.repository.TaskRepository;
import app.planer.repository.entity.NoteEntity;
import app.planer.repository.entity.TaskEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static app.planer.util.Util.transform;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final Mapper mapper;

    public List<Task> getTasks(LocalDate dateFrom, LocalDate dateTo){
        List<TaskEntity> taskEntities = taskRepository.getByCreatedDateBetween(dateFrom, dateTo);
        return transform(mapper::map, taskEntities);
    }

    public void addTask(Task task){
        task.setCreatedDate(LocalDate.now());
        TaskEntity taskEntity = mapper.map(task);
        taskRepository.save(taskEntity);
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }
}
