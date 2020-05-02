package app.planer.repository;

import app.planer.repository.entity.ShoppingItemEntity;
import app.planer.repository.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    public List<TaskEntity> getByCreatedDateBetween(LocalDate dateFrom, LocalDate dateTo);
}
