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


    // Kyseenalainen konstruktorin toteutusidea.

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

    // onkoKuollut() & olionAktiviteetti() placeholder nimet.

    /*
    Edistää olioiden tilaa eteenpäin.
    Ottaa vastaan parametrinä listan olioita.

    AE: onkoKuollut() != true
    */
    private void olioidenAktiviteetti(ArrayList oliolista) {
        for (int counter = 0; counter < oliolista.size(); counter++) {
            if (!oliolista.get(counter).onkoKuollut()) {
                oliolista.get(counter).olionAktiviteetti();
            }
        }
    }

    /*
    Simulaatio siirtyy eteenpäin.
    
    Ottaa vastaan parametrinä kuukausien määrän.

    AE: true
    */
    public void eteneSimulaatiota(int kuukausiMäärä) {
        for (int counter = 0; counter < kuukausiMäärä; counter++) {
            olioidenAktiviteetti(eliöt);
            olioidenAktiviteetti(kalat);
            olioidenAktiviteetti(kasvit);
        }
    }
}
