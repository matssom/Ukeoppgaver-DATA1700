package com.example.demo.datastrukturer;

class Node {
    int data;
    Node neste;

    public Node(int data) {
        this.data = data;
    }
}

public class MinSirkelListe {
    private Node hode = null;
    private Node hale = null;

    public void leggTilNode(int value) {
        Node nyNode = new Node(value);

        if (hode == null) {
            hode = nyNode;
        } else {
            hale.neste = nyNode;
        }

        hale = nyNode;
        hale.neste = hode;
    }

    public boolean inneholderNode(int sokeVerdi) {
        Node denneNoden = hode;

        if (hode == null) {
            return false;
        } else {
            do {
                if (denneNoden.data == sokeVerdi) {
                    return true;
                }
                denneNoden = denneNoden.neste;
            } while (denneNoden != hode);
            return false;
        }
    }

    public void slettNode(int slettVerdi) {
        Node denneNoden = hode;
        if (hode == null) {
            return;
        }
        do {
            Node nesteNode = denneNoden.neste;
            if (nesteNode.data == slettVerdi) {
                if (hale == hode) {
                    hode = null;
                    hale = null;
                } else {
                    denneNoden.neste = nesteNode.neste;
                    if (hode == nesteNode) {
                        hode = hode.neste;
                    }
                    if (hale == nesteNode) {
                        hale = denneNoden;
                    }
                }
                break;
            }
            denneNoden = nesteNode;
        } while (denneNoden != hode);
    }

    public void skrivUt() {
        Node denneNoden = hode;

        if (hode != null) {
            do {
                System.out.println(denneNoden.data + " ");
                denneNoden = denneNoden.neste;
            } while (denneNoden != hode);
        }
    }
}
