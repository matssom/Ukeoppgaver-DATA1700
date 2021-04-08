package com.example.demo.motorvogn4.controller;

import com.example.demo.motorvogn4.model.Bil4;
import com.example.demo.motorvogn4.model.Motorvogn4;
import com.example.demo.motorvogn4.repository.Bil4Repository;
import com.example.demo.motorvogn4.repository.Motorvogn4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/4")
public class Bil4Controller {

    @Autowired
    private Bil4Repository rep;

    @GetMapping("/biler")
    public List<Bil4> hentBiler() {
        return rep.hentAlleBiler();
    }

}
