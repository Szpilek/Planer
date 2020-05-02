package app.planer.repository.entity;

import app.planer.model.EventIteration;
import app.planer.model.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class EventEntity {
    @GeneratedValue
    @Id
    Integer id;
    LocalDateTime date;
    String name;
    EventType eventType;
    Boolean isEventActive;
}
