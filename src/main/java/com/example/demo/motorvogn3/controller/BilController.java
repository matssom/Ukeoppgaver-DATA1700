package com.example.demo.motorvogn3.controller;

import com.example.demo.motorvogn3.model.Bil3;
import com.example.demo.motorvogn3.repository.BilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/3")
public class BilController {

    @Autowired
    BilRepository repo;

    @PostMapping("/bil")
    public void lagre(Bil3 motorvogn) {
        repo.leggInn(motorvogn);
    }

    @GetMapping("/bil")
    public ArrayList<Bil3> hent() {
        return repo.hentAlle();
    }

    @DeleteMapping("/bil")
    public void slett() {
        repo.slettAlle();
    }

    /*
     * Utfordring:
     * Lag en metode som tar inn merke og modell og sletter kun den bilen fra serveren
     * */
}
