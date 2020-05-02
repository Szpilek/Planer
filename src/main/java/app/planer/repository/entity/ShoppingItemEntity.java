package app.planer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingItemEntity {
    @GeneratedValue
    @Id
    Integer id;
    Boolean isItemBought;
    String name;
    LocalDate itemToBuyCreated;
}
