package com.example.springboot.esercizio1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Esercizio 3: creare una nuova classe con un GetMapping che restituisca un ResponseEntity a
 * 1 - Annota una nuova classe con l'annotazione @RestController.
 * 2 - Crea un nuovo endpoint "/info" utilizzando l'annotazione @GetMapping.
 * 3 - Nel metodo, restituire un ResponseEntity con 200 OK
 */

@RestController
public class Esercizio_3 {

    @GetMapping(value = "/info")
    public ResponseEntity info() {
        return ResponseEntity.ok("200 OK");
//      oppure
//      return ResponseEntity.status(200).body("200 OK");
    }
}
