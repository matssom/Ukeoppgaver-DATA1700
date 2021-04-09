package com.example.demo.motorvogn.motorvogn3.repository;

import com.example.demo.motorvogn.motorvogn3.model.Motorvogn3;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MotorvognRepository {
    private final ArrayList<Motorvogn3> motorvognliste = new ArrayList<>();

    public void leggInn(Motorvogn3 motorvogn) {
        motorvognliste.add(motorvogn);
    }

    public ArrayList<Motorvogn3> hentAlle() {
        return motorvognliste;
    }

    public void slettAlle() {
        motorvognliste.clear();
    }
}