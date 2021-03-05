package oslomet.webprog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorvognController {

    public final List<Motorvogn> motorvognsRegister = new ArrayList<>();

    @PostMapping("/lagre")
    public void lagreKunde(Motorvogn bil){
        motorvognsRegister.add(bil);
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlle(){
        return motorvognsRegister;
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        motorvognsRegister.clear();
    }
}

