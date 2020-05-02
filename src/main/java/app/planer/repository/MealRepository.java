package app.planer.repository;

import app.planer.repository.entity.MealEntity;
import app.planer.repository.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Integer> {
    public List<MealEntity> getByDateBetween(LocalDate dateFrom, LocalDate dateTo);
}
