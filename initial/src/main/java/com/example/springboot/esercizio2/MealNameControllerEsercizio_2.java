package com.example.springboot.esercizio2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealNameControllerEsercizio_2 {

    /*
     * Esercizio 2: creare un GetMapping che restituisca un pasto per nome
     * 1 - Annota una nuova classe con l'annotazione @RestController.
     * 2 - Crea un nuovo endpoint "/meal/{name}" utilizzando l'annotazione @GetMapping.
     * 3 - Nel metodo, aggiungi un parametro di query "name" utilizzando l'annotazione @PathVariable.
     * 4 - Restituisce un oggetto Pasto con il nome corrispondente.
     */
    @Autowired
    private MealControllerEsercizio_1 mealControllerEsercizio1;

    @GetMapping(value = "/meal/{name}")
    public Meal getName(@PathVariable String name) {

        // dopo 2 ore di forI e foreach mi sono convertito agli stream

        return mealControllerEsercizio1.listaPasti().stream()
                .filter(meal -> meal.getNome().equals(name))
                .findFirst()
                .orElse(null);
    }


}
