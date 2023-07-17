package com.example.springboot.esercizio5.repo;

import com.example.springboot.esercizio5.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
