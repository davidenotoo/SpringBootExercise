package com.example.springboot.esercizio6.controller;
import com.example.springboot.esercizio6.model.Meal;
import com.example.springboot.esercizio6.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {
    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> postIngredient(@RequestBody Meal meal) {
        mealService.insertMeal(meal);
        return ResponseEntity.ok("Meal added!");
    }
    @GetMapping("/get")
    public ResponseEntity<List<Meal>> getIngredient() {
        return ResponseEntity.ok(mealService.getAllMeals());
    }
    @GetMapping("/{id}")
    public Meal getMealByID(@PathVariable Long id) {
        return mealService.getMealById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMeal(@PathVariable Long id ,@RequestBody Meal meal){
        mealService.updateMeal(id,meal);
        return ResponseEntity.ok("update ok");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeal(@PathVariable Long id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok("you are great");
    }
    @GetMapping("winterMeals")
    public ResponseEntity<List<Meal>> getWinterMeals(){
        return ResponseEntity.ok(mealService.getWinterMeals());
    }
}
