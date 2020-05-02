package app.planer.controller;

import app.planer.model.ShoppingItem;
import app.planer.model.Task;
import app.planer.service.ShoppingService;
import app.planer.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {
    public final TaskService taskService;

    @GetMapping
    List<Task> getTasks(
        @RequestParam("dateFrom")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                LocalDate dateFrom,
        @RequestParam("dateTo")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                LocalDate dateTo)
    {
        return taskService.getTasks(dateFrom, dateTo);
    }

    @PostMapping
    void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
    }
}
