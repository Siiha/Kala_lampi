package Kala_lampi;

import java.util.ArrayList;

public class Saalisraportti {
    /*
    Saalisraportin kalat.
    */
    private ArrayList<Kala> saalis;

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
    public void lisaaSaalis(Kala saalis) {
        this.saalis.add(saalis);
    }

    public String toString() {
        String s = "Saalisraportti:\n";
        for (Kala kala : saalis) {
            s += kala.getClass().getSimpleName() + "n koko: " + kala.annettuKoko() + "\n";
        }
        return s;
    }
}
