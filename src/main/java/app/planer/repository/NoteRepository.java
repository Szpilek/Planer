package app.planer.repository;

import app.planer.repository.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {
    public List<NoteEntity> getByCreatedDateBetween(LocalDate dateFrom, LocalDate dateTo);
}
