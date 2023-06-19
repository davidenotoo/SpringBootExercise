package com.example.springboot.esercizio3;

import com.example.springboot.esercizio2.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class VariController {
    private List<Meal> mealList = new ArrayList<>();

    /*
     * Esercizio 1: crea un PutMapping per aggiungere un nuovo pasto
     * 1 - Crea un nuovo endpoint "/meal" utilizzando l'annotazione @PostMapping.👍
     * 2 - Nel metodo, aggiungi un RequestBody per il nuovo oggetto Meal.👍
     * 3 - Aggiungi il nuovo pasto all'elenco dei pasti.👍
     * */
    @PostMapping("/put/meals")
    public ResponseEntity<String> putMeals(@RequestBody Meal meal) {
        this.mealList.add(meal);
        return ResponseEntity.ok("Pasto aggiunto");
    }

    @GetMapping("get/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealList);
    }


    /*
    Esercizio 2: Crea un PostMapping per aggiornare un pasto per nome
    1 - Crea un nuovo endpoint "/meal/{name}" utilizzando l'annotazione @PutMapping.
    2 - Nel metodo, aggiungi un PathVariable per il nome e un RequestBody per l'oggetto Meal aggiornato.
    3 - Aggiorna il pasto con il nome corrispondente utilizzando le informazioni del RequestBody.
    */

    @PostMapping("/meal/update/{name}")
    public ResponseEntity<String> renameMeals(@PathVariable String mealName, @RequestBody Meal newMeal) {
        for (Meal meal1 : this.mealList) {
            if (meal1.getNome().equals(mealName)) {
                mealList.remove(meal1);
                mealList.add(newMeal);
            }
        }
        return ResponseEntity.ok("Pasto aggiornato");
    }

    /*
     * Esercizio 3: creare un DeleteMapping per eliminare un pasto in base al nome
     * 1 - Crea un nuovo endpoint "/meal/{name}" utilizzando l'annotazione @DeleteMapping.
     * 2 - Nel metodo, aggiungi un PathVariable per il nome.
     * 3 - Eliminare il pasto con il nome corrispondente.
     */
    @DeleteMapping("/meal/delete/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
        for (Meal m : this.mealList) {
            if (m.getNome().equals(name)) {
                mealList.remove(m);
            }
        }
        return ResponseEntity.ok("Pasto eliminato");
    }


    /*
    Esercizio 4: crea un DeleteMapping per eliminare tutti i pasti al di sopra di un determinato prezzo
    1 - Crea un nuovo endpoint "/meal/price/{price}" utilizzando l'annotazione @DeleteMapping.
    2 - Nel metodo, aggiungi una PathVariable per il prezzo.
    3 - Elimina tutti i pasti con un prezzo superiore al prezzo da PathVariable.
    */

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteByPrice(@PathVariable Double prezzo) {
        for (Meal m : this.mealList) {
            if (m.getPrezzo() > prezzo) {
                mealList.remove(m);
            }
        }
        return ResponseEntity.ok("Rimossi i pasti con prezzo superiore a: " + prezzo);
    }


    /*
     * Esercizio 5: crea un PutMapping per aggiornare il prezzo di un pasto per nome
     * 1 - Crea un nuovo endpoint "/meal/{name}/price" utilizzando l'annotazione @PutMapping.
     * 2 - Nel metodo, aggiungi un PathVariable per il nome e un RequestBody per il prezzo aggiornato.
     * 3 - Aggiorna il prezzo del pasto con il nome corrispondente utilizzando le informazioni del RequestBody.
     */

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> updatePrizeByName(@PathVariable String nome, @RequestBody Double prezzo){
        for (Meal m : this.mealList) {
            if (m.getNome().equals(nome)) {
                m.setPrezzo(prezzo);
            }
        }
        return ResponseEntity.ok("ok");
    }
}
