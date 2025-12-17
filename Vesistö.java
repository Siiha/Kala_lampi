package Kala_lampi;

import java.util.ArrayList;

public class Vesistö {
    /*
    Muuttuja saalis- ja petokalojen listalle.
    */
    private ArrayList<Kala> kalat;

    /*
    Muuttuja kasvien listalle.
    */
    private ArrayList<Kasvi> kasvit;

    /*
    Muuttuja eliöiden listalle.
    */
    private ArrayList<Elio> eliöt;

    /*
    Luokan konstruktori.
    Ottaa vastaan parametreinä luotavien olioiden määrät.

    Luo olioita listoihin parametrien perusteella.

    AE: true
    */
    public Vesistö(int elio, int kasvi, int kala, int petokala) {
        eliöt = new ArrayList<>();
        kasvit = new ArrayList<>();
        kalat = new ArrayList<>();
    }
}
