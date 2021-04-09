package com.example.demo.motorvogn.motorvogn4.controller;

import com.example.demo.motorvogn.motorvogn4.model.Motorvogn4;
import com.example.demo.motorvogn.motorvogn4.repository.Motorvogn4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/4")
public class Motorvogn4Controller {

    @Autowired
    private Motorvogn4Repository rep;

    @PostMapping("/motorvogn")
    public void lagreKunde(Motorvogn4 motorvogn){
        rep.lagreMotorvogn(motorvogn);
    }

    @GetMapping("/motorvogner")
    public List<Motorvogn4> hentAlleMotorvogner(){
        return rep.hentAlleMotorvogner();
    }

    @DeleteMapping("/motorvogn")
    public void slettEnMotorvogn(String personnr){
        rep.slettEnMotorvogn(personnr);
    }

    @DeleteMapping("/motorvogner")
    public void slettAlleMotorvogner(){
        rep.slettAlleMotorvogner();
    }
}

