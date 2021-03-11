package com.example.demo.datastrukturer;

import static java.lang.System.exit;

public class MinStakk {

    private class Node {
        int data;
        Node neste;
    }

    Node topp;

    MinStakk() {
        this.topp = null;
    }

    public void push(int verdi)
    {
        Node temp = new Node();

        if (temp == null) {
            System.out.println("Heap overflow! (-> potensiell Stack overflow)");
            return;
        }

        temp.data = verdi;
        temp.neste = topp;
        topp = temp;
    }

    public boolean tom() {
        return topp == null;
    }

    public int se() {
        if (!tom()) {
            return topp.data;
        } else {
            System.out.println("Stakk er tom");
            return -1;
        }
    }

    public void pop()
    {
        if (topp == null) {
            System.out.println("Stack underflow!");
            return;
        }

        topp = (topp).neste;
    }

    public void skrivUt() {
        if (topp == null) {
            System.out.println("Stack underflow!");
            exit(1); // avslutter programmet og indikerer at noe gikk feil
        } else {
            Node temp = topp;
            while (temp != null) {
                System.out.printf("%d->", temp.data);
                temp = temp.neste;
            }
        }
    }
}
