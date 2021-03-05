package com.example.demo.model;

public class Belop {

    private String sort;
    private double belop;

    public Belop(String sort, double belop) {
        this.sort = sort;
        this.belop = belop;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String id) {
        this.sort = id;
    }

    public double getBelop() {
        return belop;
    }

    public void setBelop(double kurs) {
        this.belop = kurs;
    }


}
