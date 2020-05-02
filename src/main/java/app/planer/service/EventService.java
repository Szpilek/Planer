package app.planer.service;

import app.planer.controller.requests.EventRequest;
import app.planer.model.Event;
import app.planer.model.Meal;
import app.planer.repository.EventRepository;
import app.planer.repository.MealRepository;
import app.planer.repository.entity.EventEntity;
import app.planer.repository.entity.MealEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static app.planer.util.Util.transform;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final Mapper mapper;

    public List<Event> getEvents(LocalDateTime dateFrom, LocalDateTime dateTo){
        List<EventEntity> eventEntities = eventRepository.getByDateBetween(dateFrom, dateTo);
        return transform(mapper::map, eventEntities);
    }

    public void addEvent(EventRequest event){
        EventEntity eventEntity = mapper.map(event);
        eventRepository.save(eventEntity);
    }

    public void deleteEvent(Integer id){
        eventRepository.deleteById(id);
    }
}
