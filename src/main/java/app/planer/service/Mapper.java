package app.planer.service;

import app.planer.controller.requests.EventRequest;
import app.planer.model.*;
import app.planer.repository.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static app.planer.util.Util.transform;

@Component
public class Mapper {

    public Note map(NoteEntity it) {
        return Note.builder()
                .content(it.getContent())
                .createdDate(it.getCreatedDate())
                .name(it.getName())
                .build();
    }

    public NoteEntity map(Note it) {
        return NoteEntity.builder()
                .content(it.getContent())
                .createdDate(it.getCreatedDate())
                .name(it.getName())
                .build();
    }

    public Meal map(MealEntity it){
        return Meal.builder()
                .date(it.getDate())
                .name(it.getName())
                .build();
    }

    public MealEntity map(Meal it){
        return MealEntity.builder()
                .date(it.getDate())
                .name(it.getName())
                .build();
    }

    public ShoppingItemEntity map(ShoppingItem it){
        return ShoppingItemEntity.builder()
                .isItemBought(it.getIsItemBought())
                .name(it.getName())
                .itemToBuyCreated(it.getItemToBuyCreated())
                .build();
    }

    public ShoppingItem map(ShoppingItemEntity it){
        return ShoppingItem.builder()
                .isItemBought(it.getIsItemBought())
                .name(it.getName())
                .itemToBuyCreated(it.getItemToBuyCreated())
                .build();
    }

    public Task map(TaskEntity it){
        return Task.builder()
                .name(it.getName())
                .taskImportance(it.getTaskImportance())
                .taskState(it.getTaskState())
                .createdDate(it.getCreatedDate())
                .build();
    }

    public TaskEntity map(Task it){
        return TaskEntity.builder()
                .name(it.getName())
                .taskImportance(it.getTaskImportance())
                .taskState(it.getTaskState())
                .createdDate(it.getCreatedDate())
                .build();
    }

    public EventEntity map(Event it){
        return EventEntity.builder()
                .name(it.getName())
                .date(it.getDate())
                .eventType(it.getEventType())
                .isEventActive(it.getIsEventActive())
                .build();
    }

    public Event map(EventEntity it){
        return Event.builder()
                .name(it.getName())
                .date(it.getDate())
                .eventType(it.getEventType())
                .isEventActive(it.getIsEventActive())
                .build();
    }

    public EventEntity map(EventRequest eventRequest){
        return EventEntity.builder()
                .date(eventRequest.getDate())
                .eventType(eventRequest.getEventType())
                .name(eventRequest.getName())
                .isEventActive(eventRequest.getIsEventActive())
                .build();
    }
}
