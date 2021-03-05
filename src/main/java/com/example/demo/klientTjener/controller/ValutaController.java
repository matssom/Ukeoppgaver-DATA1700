package com.example.demo.klientTjener.controller;

import com.example.demo.klientTjener.model.Belop;
import com.example.demo.klientTjener.model.Valuta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ValutaController {

    private ArrayList<Valuta> valutaRegister = new ArrayList<>();

    @PostMapping("/valuta")
    public void opprettValuta() {
        Valuta sek = new Valuta("SEK",1.02);
        Valuta usd = new Valuta("USD",8.50);
        Valuta eur = new Valuta("EUR",9.56);
        valutaRegister.add(sek);
        valutaRegister.add(usd);
        valutaRegister.add(eur);
    }

    @GetMapping("/valuta")
    public double beregn(Belop belop) {
        double kurs = 0;

        for (Valuta valuta : valutaRegister) {

            if (valuta.getSort().equals(belop.getSort())) {
                kurs = valuta.getKurs();
                break;
            }
        }

        return belop.getBelop() * kurs;
    }

}
