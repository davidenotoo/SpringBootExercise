package com.example.springboot.esercizio2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MealDescriptionControllerEsercizio_3 {

    /*
     * Esercizio 3: Crea un GetMapping che restituisca un pasto con qualsiasi parola di descrizione
     * 1 - Annota una nuova classe con l'annotazione @RestController.
     * 2 - Crea un nuovo endpoint "/meal/description-match/{phrase}" utilizzando l'annotazione @GetMapping.
     * 3 - Nel metodo, aggiungi una "descrizione" del parametro di query utilizzando l'annotazione @PathVariable.
     * 4 - Restituisci un oggetto Pasto con la descrizione corrispondente.
     */
    @Autowired
    private MealControllerEsercizio_1 mealControllerEsercizio1;

    @GetMapping(value = "/meal/description-match/{phrase}")
    public List<Meal> getDescriptionMatch(@PathVariable String phrase) {
        // penso sia un esercizio tipo "ctrl+F" quindi se la parola
        // che inseriamo è contenuta nella descrizione di un pasto
        // allora il pasto viene aggiunto alla lista.
        return mealControllerEsercizio1.listaPasti().stream()
                .filter(meal -> meal.getDescrizione().contains(phrase))
                .collect(Collectors.toList());
    }
}