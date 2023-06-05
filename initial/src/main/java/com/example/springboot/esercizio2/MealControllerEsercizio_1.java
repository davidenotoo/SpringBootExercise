package com.example.springboot.esercizio2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MealControllerEsercizio_1 {

    /*
     * Esercizio 1: creare un GetMapping che restituisca un elenco di pasti
     * 1 - Annota una nuova classe con l'annotazione @RestController.
     * 2 - Crea un nuovo endpoint "/meal" utilizzando l'annotazione @GetMapping.
     * 3 - Nel metodo, restituisce un elenco di oggetti Meal.
     */
    @GetMapping(value = "/meals")
    public List<Meal> listaPasti() {
        return Arrays.asList(
                new Meal("Pizza", "Margherita", 13.99),
                new Meal("Pasta", "Alfredo", 15.99),
                new Meal("Mandolino", "4 corde", 55.99)
        );
    }


}
