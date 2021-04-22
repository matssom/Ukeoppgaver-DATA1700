package com.example.demo.motorvogn.motorvogn6.model;

public class Bil6 {
    private String merke;
    private String type;

    public Bil6(String merke, String type) {
        this.merke = merke;
        this.type = type;
    }

    public Bil6() {
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
