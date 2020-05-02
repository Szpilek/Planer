package app.planer.service;

import app.planer.model.Meal;
import app.planer.repository.MealRepository;
import app.planer.repository.NoteRepository;
import app.planer.repository.entity.MealEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static app.planer.util.Util.transform;

@Service
@AllArgsConstructor
public class MealService {
    private final MealRepository mealRepository;
    private final Mapper mapper;

    public List<Meal> getMeals(LocalDate dateFrom, LocalDate dateTo){
        List<MealEntity> mealEntities = mealRepository.getByDateBetween(dateFrom, dateTo);
        return transform(mapper::map, mealEntities);
    }

    public void addMeal(Meal meal){
        MealEntity mealEntity = mapper.map(meal);
        mealRepository.save(mealEntity);
    }

    public void deleteMeal(Integer id){
        mealRepository.deleteById(id);
    }
}
