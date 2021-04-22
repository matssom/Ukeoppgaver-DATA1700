package com.example.demo.motorvogn.motorvogn7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class Motorvogn7Controller {

    @Autowired
    private Motorvogn7Repository rep;

    private Logger logger = LoggerFactory.getLogger(Motorvogn7Controller.class);

    @GetMapping("/hentBiler7")
    public List<Bil7> hentBiler(HttpServletResponse response) throws IOException {
        List<Bil7> alleBiler = rep.hentAlleBiler();
        if(alleBiler==null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
        return alleBiler;
    }

    @PostMapping("/lagre7")
    public void lagreKunde(Motorvogn7 motorvogn, HttpServletResponse response) throws IOException {
        if(validerMotorvognOK(motorvogn)){
            if(!rep.lagreMotorvogn(motorvogn)){
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
            }
        }
        else{
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Valideringsfeil -prøv igjen senere");
        }
    }

    @GetMapping("/hentAlle7")
    public List<Motorvogn7> hentAlleMotorvogner(HttpServletResponse response) throws IOException {
        List<Motorvogn7> alleMotorvogner = rep.hentAlleMotorvogner();
        if(alleMotorvogner==null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
        return alleMotorvogner;
    }

    @GetMapping("/henteEnMotorvogn7")
    public Motorvogn7 henteEnMotorvogn(int id, HttpServletResponse response) throws IOException{
        Motorvogn7 enMotorvogn = rep.henteEnMotorvogn(id);
        if(enMotorvogn == null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
        return enMotorvogn;
    }

    @PostMapping("/endre7")
    public void endre(Motorvogn7 motorvogn, HttpServletResponse response) throws IOException{

        if(validerMotorvognOK(motorvogn)){
            if(!rep.endreMotorvogn(motorvogn)){
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
            }
        }
        else{
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Valideringsfeil -prøv igjen senere");
        }
    }

    @GetMapping("/slettEnMotorvogn7")
    public void slettEnMotorvogn(String personnr, HttpServletResponse response) throws IOException{
        if(!rep.slettEnMotorvogn(personnr)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
    }

    @GetMapping("/slettAlle7")
    public void slettAlleMotorvogner(HttpServletResponse response) throws IOException{
        if(!rep.slettAlleMotorvogner()){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
    }

    private boolean validerMotorvognOK(Motorvogn7 motorvogn){
        String regexPersonnr = "[0-9]{11}";
        String regexNavn = "[a-zA-ZæøåÆØÅ .\\-]{2,20}";
        String regexAdresse = "[0-9a-zA-ZæøåÆØÅ ,.\\-]{2,40}";
        String regexKjennetegn = "[A-Z][A-Z][0-9]{5}";
        String regexMerke = "[a-zA-ZæøåÆØÅ.\\-]{2,10}";
        String regexType = "[0-9a-zA-ZæøåÆØÅ.\\-]{2,10}";
        boolean personnrOK = motorvogn.getPersonnr().matches(regexPersonnr);
        boolean navnOK = motorvogn.getNavn().matches(regexNavn);
        boolean adresseOK = motorvogn.getAdresse().matches(regexAdresse);
        boolean kjennetegnOK = motorvogn.getKjennetegn().matches(regexKjennetegn);
        boolean merkeOK = motorvogn.getMerke().matches(regexMerke);
        boolean typeOK = motorvogn.getType().matches(regexType);
        if (personnrOK && navnOK && adresseOK && kjennetegnOK && merkeOK && typeOK ){
            return true;
        }
        logger.error("Valideringsfeil");
        return false;
    }
}

