package com.example.springboot.esercizio6.repository;

import com.example.springboot.esercizio6.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {
    List<Meal> findByIsWinterMeal(boolean isWinterMeal);
}