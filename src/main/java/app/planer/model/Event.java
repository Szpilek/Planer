package app.planer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDateTime date;
    String name;
    EventType eventType;
    Boolean isEventActive;
}
