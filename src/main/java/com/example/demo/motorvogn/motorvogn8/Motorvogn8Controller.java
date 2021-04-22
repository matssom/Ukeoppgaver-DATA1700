package com.example.demo.motorvogn.motorvogn8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/8")
public class Motorvogn8Controller {

    @Autowired
    private Motorvogn8Repository rep;

    @Autowired
    private HttpSession session;

    private Logger logger = LoggerFactory.getLogger(Motorvogn8Controller.class);

    @GetMapping("/hentBiler")
    public List<Bil8> hentBiler(HttpServletResponse response) throws IOException {
        List<Bil8> alleBiler = rep.hentAlleBiler();
        if(alleBiler==null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
        return alleBiler;
    }

    @PostMapping("/lagre")
    public void lagreKunde(Motorvogn8 motorvogn, HttpServletResponse response) throws IOException {
        if(validerMotorvognOK(motorvogn)){
            if(!rep.lagreMotorvogn(motorvogn)){
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
            }
        }
        else{
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Valideringsfeil -prøv igjen senere");
        }
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn8> hentAlleMotorvogner(HttpServletResponse response) throws IOException {
        if((boolean) session.getAttribute("loggetInn")){
            List<Motorvogn8> alleMotorvogner = rep.hentAlleMotorvogner();
            if(alleMotorvogner==null){
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
            }
            return alleMotorvogner;
        }
        else{
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Kan ikke vise register: Du er ikke logget inn!");
            return null;
        }
    }

    @GetMapping("/henteEnMotorvogn")
    public Motorvogn8 henteEnMotorvogn(int id, HttpServletResponse response) throws IOException{
        Motorvogn8 enMotorvogn = rep.henteEnMotorvogn(id);
        if(enMotorvogn == null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
        return enMotorvogn;
    }

    @PostMapping("/endre")
    public void endre(Motorvogn8 motorvogn, HttpServletResponse response) throws IOException{

        if(validerMotorvognOK(motorvogn)){
            if(!rep.endreMotorvogn(motorvogn)){
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
            }
        }
        else{
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Valideringsfeil -prøv igjen senere");
        }
    }

    @GetMapping("/slettEnMotorvogn")
    public void slettEnMotorvogn(String personnr, HttpServletResponse response) throws IOException{
        if(!rep.slettEnMotorvogn(personnr)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
    }

    @GetMapping("/slettAlle")
    public void slettAlleMotorvogner(HttpServletResponse response) throws IOException{
        if(!rep.slettAlleMotorvogner()){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i DB -prøv igjen senere");
        }
    }

    private boolean validerMotorvognOK(Motorvogn8 motorvogn){
        String regexPersonnr = "[0-9]{11}";
        String regexNavn = "[a-zA-ZæøåÆØÅ.\\-]{2,20}";
        String regexAdresse = "[0-9a-zA-ZæøåÆØÅ.\\-]{2,30}";
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

    @GetMapping("/loggInn")
    public boolean loggInn(String brukernavn, String passord) {
        if (rep.loggInn(brukernavn, passord)){
            session.setAttribute("loggetInn",true);
            return true;
        }
        else{
            return false;
        }
    }

    @GetMapping("/loggUt")
    public void loggUt() {
        session.setAttribute("loggetInn",false);
    }
}

