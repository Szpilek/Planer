package app.planer.repository;

import app.planer.repository.entity.EventEntity;
import app.planer.repository.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    public List<EventEntity> getByDateBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
