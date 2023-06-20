package com.example.springboot.esercizio4.service;

import com.example.springboot.esercizio2.Meal;
import com.example.springboot.esercizio4.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;
    @Autowired
    public MealService(MealDao mealDao){
        this.mealDao = mealDao;
    }
    public void addMeal(Meal meal) {
        mealDao.addMeal(meal);
    }

    public void deleteMeal(String mealName) {
        mealDao.deleteMeal(mealName);
    }

    public void updateMeal(Meal meal) {
        mealDao.updateMeal(meal);
    }

    public List<Meal> getMeals() {
        return mealDao.getMeals();
    }
}
