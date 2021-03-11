package com.example.demo.datastrukturer;

public class DatastrukturerDemo {

    public static void main(String[] args) {
        System.out.println("Ukeoppgaver - datastrukturer");

        // Sirkulær enveis liste
        System.out.println("Sirkulær enveis liste");

        MinSirkelListe minSirkelListe = new MinSirkelListe();

        minSirkelListe.leggTilNode(13);
        minSirkelListe.leggTilNode(7);
        minSirkelListe.leggTilNode(24);
        minSirkelListe.leggTilNode(1);
        minSirkelListe.leggTilNode(8);
        minSirkelListe.leggTilNode(37);
        minSirkelListe.leggTilNode(46);

        int tall = 8;

        if(minSirkelListe.inneholderNode(tall)) {
            System.out.println("Listen inneholder " + tall);
        }
        else {
            System.out.println("Listen inneholder ikke " + tall);
        }

        minSirkelListe.slettNode(2);

        if(minSirkelListe.inneholderNode(tall)) {
            System.out.println("Listen inneholder " + tall);
        }
        else {
            System.out.println("Listen inneholder ikke " + tall);
        }

        minSirkelListe.skrivUt();

        // Stack
        System.out.println("Stakk!");

        MinStakk minStakk = new MinStakk();

        minStakk.push(11);
        minStakk.push(22);
        minStakk.push(33);
        minStakk.push(44);

        minStakk.skrivUt();

        System.out.println("Første tall i stakken er " + minStakk.se());

        minStakk.pop();
        minStakk.pop();

        minStakk.skrivUt();

        System.out.println("Første tall i stakken er " + minStakk.se());
    }
}