package Kala_lampi;

import java.util.ArrayList;

public class Saalisraportti {
    /*
    Saalisraportin kalat.
    */
    private ArrayList<Kuolevainen> saalis;

    /*
    Konstruktori saalisraportille.
    Luo objektille tyhjän listan.

    AE: true
    */
    public Saalisraportti() {
        this.saalis = new ArrayList<>();
    }

    /*
    Lisää saalisraporttiin parametrina saadun
    saaliin.

    AE: true
    */
    public void lisaaSaalis(Kuolevainen saalis) {
        this.saalis.add(saalis);
    }
}
