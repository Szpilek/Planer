package app.planer.controller;

import app.planer.model.ShoppingItem;
import app.planer.service.ShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/shopping-item")
public class ShoppingController {
    public final ShoppingService shoppingService;

    @GetMapping
    List<ShoppingItem> getItems(
            @RequestParam("dateFrom")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate dateFrom,
            @RequestParam("dateTo")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate dateTo
    ){
        return shoppingService.getItems(dateFrom, dateTo);
    }

    @PostMapping
    ResponseEntity addItem(@RequestBody ShoppingItem shoppingItem){
        shoppingService.addItem(shoppingItem);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteItem(@PathVariable Integer id){
        shoppingService.deleteItem(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
