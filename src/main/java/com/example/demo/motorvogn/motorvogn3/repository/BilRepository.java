package com.example.demo.motorvogn.motorvogn3.repository;

import com.example.demo.motorvogn.motorvogn3.model.Bil3;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BilRepository {
    private final ArrayList<Bil3> billiste = new ArrayList<>();

    public BilRepository() {
        this.billiste.add(new Bil3("Audi", "R8 V10+"));
        this.billiste.add(new Bil3("Audi", "RS4"));
        this.billiste.add(new Bil3("Audi", "A3"));
        this.billiste.add(new Bil3("Porche", "Tycan Turbo s"));
        this.billiste.add(new Bil3("Porche", "911"));
        this.billiste.add(new Bil3("Volvo", "XC90"));
        this.billiste.add(new Bil3("Volvo", "XC60"));
        this.billiste.add(new Bil3("Volvo", "XC40"));
        this.billiste.add(new Bil3("Tesla", "Cyber Truck"));
        this.billiste.add(new Bil3("Tesla", "Model 3"));
        this.billiste.add(new Bil3("Tesla", "Model S"));
    }

    public void leggInn(Bil3 motorvogn) {
        billiste.add(motorvogn);
    }

    public ArrayList<Bil3> hentAlle() {
        return billiste;
    }

    public void slettAlle() {
        billiste.clear();
    }
}