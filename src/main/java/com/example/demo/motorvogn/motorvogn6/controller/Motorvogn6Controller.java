package com.example.demo.motorvogn.motorvogn6.controller;

import com.example.demo.motorvogn.motorvogn6.repository.Motorvogn6Repository;
import com.example.demo.motorvogn.motorvogn6.model.Bil6;
import com.example.demo.motorvogn.motorvogn6.model.Motorvogn6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/6")
public class Motorvogn6Controller {

    @Autowired
    private Motorvogn6Repository rep;

    @PostMapping("/motorvogner")
    public void lagreKunde(Motorvogn6 motorvogn, HttpServletResponse response) throws IOException {
        if(!rep.lagreMotorvogn(motorvogn)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
    }

    @GetMapping("/motorvogner")
    public List<Motorvogn6> hentAlleMotorvogner(HttpServletResponse response) throws IOException {
        List<Motorvogn6> alleMotorvogner = rep.hentAlleMotorvogner();
        if(alleMotorvogner==null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
        return alleMotorvogner;
    }

    @GetMapping("/motorvogn")
    public Motorvogn6 henteEnMotorvogn(int id, HttpServletResponse response) throws IOException{
        Motorvogn6 enMotorvogn = rep.henteEnMotorvogn(id);
        if(enMotorvogn == null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
        return enMotorvogn;
    }

    @PutMapping("/motorvogn")
    public void endre(Motorvogn6 motorvogn, HttpServletResponse response) throws IOException{
        if(!rep.endreMotorvogn(motorvogn)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
    }

    @DeleteMapping("/motorvogn")
    public void slettEnMotorvogn(int personnr, HttpServletResponse response) throws IOException{
        if(!rep.slettEnMotorvogn(personnr)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
    }

    @DeleteMapping("/motorvogner")
    public void slettAlleMotorvogner(HttpServletResponse response) throws IOException{
        if(!rep.slettAlleMotorvogner()){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
    }
}

