package com.example.demo.motorvogn.motorvogn1.controller;

import com.example.demo.motorvogn.motorvogn1.model.Motorvogn;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/1")
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
