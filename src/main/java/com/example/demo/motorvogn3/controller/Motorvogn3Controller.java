package com.example.demo.motorvogn3.controller;

import com.example.demo.motorvogn3.model.Bil3;
import com.example.demo.motorvogn3.model.Motorvogn3;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("3")
public class Motorvogn3Controller {

    public final List<Motorvogn3> motorvognsRegister = new ArrayList<>();
    public final List<Bil3> bilRegister = new ArrayList<>();

    public Motorvogn3Controller() {
        Bil3 bil1 = new Bil3("Volvo","V30");
        bilRegister.add(bil1);
        Bil3 bil2 = new Bil3("Volvo","V70");
        bilRegister.add(bil2);
        Bil3 bil3 = new Bil3("Volvo","V91");
        bilRegister.add(bil3);
        Bil3 bil4 = new Bil3("Audi","A8");
        bilRegister.add(bil4);
        Bil3 bil5 = new Bil3("Audi","Q7");
        bilRegister.add(bil5);
        Bil3 bil6 = new Bil3("Audi","Q8");
        bilRegister.add(bil6);
    }

    @GetMapping("/biler")
    public List<Bil3> hentBiler() {
        return bilRegister;
    }

    @PostMapping("/motorvogn")
    public void lagreKunde(Motorvogn3 bil){
        motorvognsRegister.add(bil);
    }

    @GetMapping("/motorvogn")
    public List<Motorvogn3> hentAlle(){
        return motorvognsRegister;
    }

    @DeleteMapping("/motorvogn")
    public void slettAlle(){
        motorvognsRegister.clear();
    }
}

