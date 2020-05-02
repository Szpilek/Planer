package app.planer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingItem {
    Boolean isItemBought;
    String name;
    LocalDate itemToBuyCreated;
}
