package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Esercizi_1_2 {


    /*
     * Esercizio 1:
     * 1 - Crea un nuovo endpoint "/hello" utilizzando l'annotazione @GetMapping.
     * 2 - Nel metodo, restituisce una stringa semplice come "Hello World!".
     */
    @GetMapping(value = "/hello")
    public String index() {
        return "Hello World!";
    }


    /*
     * Esercizio 2: creare un GetMapping che restituisca una ResponseEntity come risposta
     * 1 - Crea un nuovo endpoint "/greeting" utilizzando l'annotazione @GetMapping.
     * 2 - Nel metodo, restituire un oggetto ResponseEntity con un messaggio stringa come "Buon pomeriggio!".
     * 3 - Puoi anche impostare il codice di stato HTTP in ResponseEntity, ad esempio "200 OK".
     */
    @GetMapping(value = "/greeting")
    public ResponseEntity<String> greeting() {
        if (new Date().getHours() < 12) {
            // esempio di errore 400 in caso sia mattina; (.status(400)e affini)
            return ResponseEntity.badRequest().body("è mattina");
        }
        // in caso di stato 200 (o semplicemente .ok) caccia Buon pomeriggio
        return ResponseEntity.status(200).body("Buon pomeriggio");
       // return ResponseEntity.ok("Buon pomeriggio"); stesso metodo
    }



}
