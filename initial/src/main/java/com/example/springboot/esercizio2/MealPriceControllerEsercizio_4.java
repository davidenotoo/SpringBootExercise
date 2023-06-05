package com.example.springboot.esercizio2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MealPriceControllerEsercizio_4 {

    /*
     *  Esercizio 4: Crea un GetMapping che restituisca un pasto per fascia di prezzo
     *  1 - Annota una nuova classe con l'annotazione @RestController.
     *  2 - Crea un nuovo endpoint "/meal/price" utilizzando l'annotazione @GetMapping.
     *  3 - Nel metodo, aggiungi due parametri di query "min" e "max" utilizzando l'annotazione @RequestParam.
     *  4 - Restituisce un elenco di oggetti Pasto con prezzi compresi nell'intervallo specificato.
     */

    @Autowired
    private MealControllerEsercizio_1 mealControllerEsercizio1;

    @GetMapping(value = "/meal/price")
    public List<Meal> getPriceRange(@RequestParam("min") Double prezzoMin, @RequestParam("max") Double prezzoMax) {
        return mealControllerEsercizio1.listaPasti().stream()
                .filter(meal -> meal.getPrezzo() >= prezzoMin && meal.getPrezzo() <= prezzoMax)
                .collect(Collectors.toList());
    }
}
