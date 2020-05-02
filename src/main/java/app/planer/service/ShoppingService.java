package app.planer.service;

import app.planer.model.ShoppingItem;
import app.planer.repository.ShoppingRepository;
import app.planer.repository.entity.ShoppingItemEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static app.planer.util.Util.transform;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingService {
    private final ShoppingRepository shoppingRepository;
    private final Mapper mapper;

    public List<ShoppingItem> getItems(LocalDate dateFrom, LocalDate dateTo){
        List<ShoppingItemEntity> shoppingItemEntities = shoppingRepository.getByItemToBuyCreatedBetween(dateFrom, dateTo);
        return transform(mapper::map, shoppingItemEntities);
    }

    public void addItem(ShoppingItem shoppingItem){
        shoppingItem.setItemToBuyCreated(LocalDate.now());
        ShoppingItemEntity shoppingItemEntity = mapper.map(shoppingItem);
        shoppingRepository.save(shoppingItemEntity);
    }

    public void deleteItem(Integer id){
        shoppingRepository.deleteById(id);
    }
}
