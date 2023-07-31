package com.example.springboot.esercizio6.repository;

import com.example.springboot.esercizio6.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

}
