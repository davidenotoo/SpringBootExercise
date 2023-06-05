package com.example.springboot.esercizio1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Esercizio_4 {
    /*
    * Esercizio 4: creare un GetMapping che restituisca 400 - Richiesta errata o 200 - OK in base a un valore booleano casuale
    * 1 - Annota una nuova classe con l'annotazione @RestController.
    * 2 - Crea un nuovo endpoint "/random" utilizzando l'annotazione @GetMapping.
    * 3 - Nel metodo, restituire un ResponseEntity con 200 OK o 400 Bad Request in base al risultato di new Random().nextBoolean()
    */

    @GetMapping(value = "/random")
    public ResponseEntity random(){
        if (new Random().nextBoolean()){
            return ResponseEntity.ok("200 ok");
//            return ResponseEntity.status(200).body("200 ok");
        }
        return ResponseEntity.badRequest().body("Errore 400");
//      return ResponseEntity.status(400).body("Errore 400");
    }
}
