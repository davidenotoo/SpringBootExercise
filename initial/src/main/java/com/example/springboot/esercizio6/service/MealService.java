package com.example.springboot.esercizio6.service;

import com.example.springboot.esercizio6.model.Meal;
import com.example.springboot.esercizio6.repository.MealRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    private MealRepository mealRepository;
    private Double maxTemp = 8.2;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void insertMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public Meal getMealById(Long id) throws ResponseStatusException {
        Optional<Meal> optionalMeal = mealRepository.findById(id);
        if (optionalMeal.isEmpty()) {
            Meal meal = optionalMeal.get();
            return new Meal(meal.getId(), meal.getName(), meal.getDescription(),
                    meal.getPrice(), meal.getIngredients(), meal.isWinterMeal());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Meal not found with ID: " + id
            );
        }

    }

    public void updateMeal(Long id, Meal meal) {
        mealRepository.deleteById(id);
        mealRepository.save(meal);
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }

    public List<Meal> getWinterMeals() {
        Double currentTemperature = getCurrentTemperature();
        if (currentTemperature > maxTemp) return new ArrayList<>();
        return mealRepository.findByIsWinterMeal(true);
    }

    private Double getCurrentTemperature() {
        try {
            JSONPObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=-35.2835&longitude=149.1281&current_weather=true")
                    .asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
