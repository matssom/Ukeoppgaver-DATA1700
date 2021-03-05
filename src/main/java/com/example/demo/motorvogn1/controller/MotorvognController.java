package com.example.demo.motorvogn1.controller;

import com.example.demo.motorvogn1.model.Motorvogn;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorvognController {

    public final List<Motorvogn> motorvognsRegister = new ArrayList<>();

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
