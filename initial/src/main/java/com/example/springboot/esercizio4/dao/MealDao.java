package com.example.springboot.esercizio4.dao;

import com.example.springboot.esercizio2.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDao {
    private List<Meal> mealList = new ArrayList<>();

    public void addMeal(Meal meal) {
        if (meal == null) throw new IllegalArgumentException("Meal cannot be null");
        if (meal.getNome() == null ||meal.getNome().isEmpty()) throw new IllegalArgumentException("Meal name cannot be null or empty");
        if (meal.getDescrizione() == null ||meal.getDescrizione().isEmpty()) throw new IllegalArgumentException("Meal description cannot be null or empty");
        if (meal.getPrezzo() <= 0) throw new IllegalArgumentException("Meal price cannot be less than or equal to 0!");
        if (meal.getPrezzo() > 100) throw new IllegalArgumentException("Meal price cannot be greater than 100!");
        this.mealList.add(meal);
    }

    public void deleteMeal(String mealName) {
        this.mealList.removeIf(meal -> meal.getNome().equals(mealName));
    }

    public void updateMeal(Meal meal) {
        this.mealList.removeIf(meal1 -> meal1.getNome().equals(meal.getNome()));
        this.mealList.add(meal);
    }

    public List<Meal> getMeals() {
        return this.mealList;
    }
}
