package com.example.demo.motorvogn2.controller;

import com.example.demo.motorvogn2.model.Motorvogn2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/2")
public class Motorvogn2Controller {

    public final List<Motorvogn2> motorvognsRegister = new ArrayList<>();

    @PostMapping("/motorvogn")
    public void lagreKunde(Motorvogn2 bil){
        motorvognsRegister.add(bil);
    }

    @GetMapping("/motorvogn")
    public List<Motorvogn2> hentAlle(){
        return motorvognsRegister;
    }

    @DeleteMapping("/motorvogn")
    public void slettAlle(){
        motorvognsRegister.clear();
    }
}

