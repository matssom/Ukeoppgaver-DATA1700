package com.example.demo.motorvogn3.controller;

import com.example.demo.motorvogn3.model.Motorvogn3;
import com.example.demo.motorvogn3.repository.MotorvognRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class Motorvogn3Controller {

    @Autowired
    MotorvognRepository repo;

    @PostMapping("/motor")
    public void lagre(Motorvogn3 motorvogn) {
        repo.leggInn(motorvogn);
    }

    @GetMapping("/motor")
    public ArrayList<Motorvogn3> hent() {
        return repo.hentAlle();
    }

    @DeleteMapping("/motor")
    public void slett() {
        repo.slettAlle();
    }
}