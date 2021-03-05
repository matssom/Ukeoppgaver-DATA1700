package com.example.demo.motorvogn3.controller;

import com.example.demo.motorvogn3.model.Bil;
import com.example.demo.motorvogn3.model.Motorvogn;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("3")
public class MotorvognController {

    public final List<Motorvogn> motorvognsRegister = new ArrayList<>();
    public final List<Bil> bilRegister = new ArrayList<>();

    public MotorvognController () {
        Bil bil1 = new Bil("Volvo","V30");
        bilRegister.add(bil1);
        Bil bil2 = new Bil("Volvo","V70");
        bilRegister.add(bil2);
        Bil bil3 = new Bil("Volvo","V91");
        bilRegister.add(bil3);
        Bil bil4 = new Bil("Audi","A8");
        bilRegister.add(bil4);
        Bil bil5 = new Bil("Audi","Q7");
        bilRegister.add(bil5);
        Bil bil6 = new Bil("Audi","Q8");
        bilRegister.add(bil6);
    }

    @GetMapping("/biler")
    public List<Bil> hentBiler() {
        return bilRegister;
    }

    @PostMapping("/motorvogn")
    public void lagreKunde(Motorvogn bil){
        motorvognsRegister.add(bil);
    }

    @GetMapping("/motorvogn")
    public List<Motorvogn> hentAlle(){
        return motorvognsRegister;
    }

    @DeleteMapping("/motorvogn")
    public void slettAlle(){
        motorvognsRegister.clear();
    }
}

