package com.example.demo.model;

public class Valuta {

    private String sort;
    private double kurs;

    public Valuta(String sort, double kurs) {
        this.sort = sort;
        this.kurs = kurs;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String id) {
        this.sort = id;
    }

    public double getKurs() {
        return kurs;
    }

    public void setKurs(double kurs) {
        this.kurs = kurs;
    }
}
