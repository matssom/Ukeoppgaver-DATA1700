package com.example.demo.motorvogn.motorvogn6.controller;

import com.example.demo.motorvogn.motorvogn3.repository.BilRepository;
import com.example.demo.motorvogn.motorvogn6.model.Bil6;
import com.example.demo.motorvogn.motorvogn6.repository.Bil6Repository;
import com.example.demo.motorvogn.motorvogn6.repository.Motorvogn6Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/6")
public class Bil6Controller {

    @Autowired
    private Bil6Repository rep;

    @GetMapping("/biler")
    public List<Bil6> hentBiler(HttpServletResponse response) throws IOException {
        List<Bil6> alleBiler = rep.hentAlleBiler();
        if(alleBiler==null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
        return alleBiler;
    }

}
