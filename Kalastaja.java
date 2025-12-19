package Kala_lampi;

import java.util.ArrayList;

public class Kalastaja {
    /*
    Muuttuja kalastajan valitsemalle vieheelle.
    */
    private Viehe viehe;

    /*
    Muuttuja kalastajan saalisraportille.
    */
    private Saalisraportti raportti;

    /*
    Konstruktori kalastajalle.

    Asettaa kalastajalle perusvieheen sekä saalisraportin.

    AE: true
    */
    public Kalastaja() {
        this.viehe = new Viehe();
        raportti = new Saalisraportti();
    } 

    /*
    Ottaa vastaan parametrinä vieheen, joka asetetaan
    kalastajan nykyiseksi.

    AE: true
    */
    public void valitseViehe(Viehe viehe) {
        this.viehe = viehe;
    }

    /*
    Yrittää kalastaa parametrinä annetusta listasta kalan.
    Kiinnijäädessä saalis lisätään Saalisraporttiin ja saalis
    kuolee.

    AE: kalalista != null && onkoKuollut() == false
    */
    public void kalasta(ArrayList<Kala> kalalista) {
        if (kalalista != null) {
            int rng = (int)(Math.random() * kalalista.size());
            Kala eräs = kalalista.get(rng);
            if (!eräs.onkoKuollut()) {
                if (viehe.jaikoKiinni(eräs)) {
                    raportti.lisaaSaalis(eräs);
                    eräs.kuole();
                }
            }
        }
    }

    /*
    Palauttaa kalastajan saalisraportin.

    AE: true
    */
    public Saalisraportti haeRaportti() {
        return this.raportti;
    }
}
