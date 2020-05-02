package app.planer.controller;

import app.planer.model.Event;
import app.planer.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @GetMapping
    List<Event> getEvents(
            @RequestParam("dateFrom")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    LocalDateTime dateFrom,
            @RequestParam("dateTo")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    LocalDateTime dateTo
    ) {
        return eventService.getEvents(dateFrom, dateTo);
    }

    @PostMapping
    void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
    }
}
