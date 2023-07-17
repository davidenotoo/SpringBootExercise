package com.example.springboot.esercizio5.controller;

import com.example.springboot.esercizio5.services.IngredientService;
import com.example.springboot.esercizio5.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        Optional<Ingredient> ingredient = ingredientService.getIngredientById(id);
        if (ingredient.isPresent()) {
            return ResponseEntity.ok().body(ingredient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient savedIngredient = ingredientService.saveIngredient(ingredient);
        return ResponseEntity.ok().body(savedIngredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(
            @PathVariable Long id,
            @RequestBody Ingredient updatedIngredient
    ) {
        Optional<Ingredient> existingIngredient = ingredientService.getIngredientById(id);
        if (existingIngredient.isPresent()) {
            Ingredient ingredient = existingIngredient.get();
            ingredient.setName(updatedIngredient.getName());
            ingredient.setVegetarian(updatedIngredient.isVegetarian());
            ingredient.setVegan(updatedIngredient.isVegan());
            ingredient.setGlutenFree(updatedIngredient.isGlutenFree());
            ingredient.setLactoseFree(updatedIngredient.isLactoseFree());
            Ingredient savedIngredient = ingredientService.saveIngredient(ingredient);
            return ResponseEntity.ok().body(savedIngredient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().body("Ingrediente cancellato correttamente");
    }
}
