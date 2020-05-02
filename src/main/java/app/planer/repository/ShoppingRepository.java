package app.planer.repository;

import app.planer.repository.entity.ShoppingItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShoppingRepository extends JpaRepository<ShoppingItemEntity, Integer> {
    public List<ShoppingItemEntity> getByItemToBuyCreatedBetween(LocalDate dateFrom, LocalDate dateTo);
}
