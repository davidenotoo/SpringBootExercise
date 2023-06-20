package com.example.springboot.esercizio4.controller;


import com.example.springboot.esercizio2.Meal;
import com.example.springboot.esercizio4.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("get/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PostMapping("/put/meals")
    public ResponseEntity<String> putMeals(@RequestBody Meal meal) {
        try {
            mealService.addMeal(meal);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Meal added!");
    }

    @DeleteMapping("/delete/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
        mealService.deleteMeal(name);
        return ResponseEntity.ok("Meal deleted!");
    }

    @PostMapping("/post/replace-meal")
    public ResponseEntity<String> postMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok("Meal updated!");

    }
}
