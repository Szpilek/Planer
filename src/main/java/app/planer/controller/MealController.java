package app.planer.controller;

import app.planer.model.Meal;
import app.planer.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/meal")
public class MealController {
    private final MealService mealService;

    @GetMapping
    List<Meal> getMeals(
            @RequestParam("dateFrom")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate dateFrom,
            @RequestParam("dateTo")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate dateTo
    ){
        return mealService.getMeals(dateFrom, dateTo);
    }

    @PostMapping
    ResponseEntity addMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteMeal(@PathVariable Integer id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
