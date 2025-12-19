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
        
        for (int counter = 0; counter < elio; counter++) {
            Elio eräs = Elio.luoElio();
            eräs.asetaSaaliit(kasvit);
            eliöt.add(eräs);
        }

        for (int counter = 0; counter < kasvi; counter++) {
            Kasvi eräs = Kasvi.luoKasvi();
            kasvit.add(eräs);
        }

        for (int counter = 0; counter < kala; counter++) {
            Kala eräs = Kala.luoKala(eliöt);
            kalat.add(eräs);
        }

        for (int counter = 0; counter < petokala; counter++) {
            Petokala eräs = Petokala.luoPetokala(eliöt, kalat);
            kalat.add(eräs);
        }
    }

    /*
    Edistää eliöiden tilaa eteenpäin.
    Ottaa vastaan parametrinä listan eliöitä.

    AE: onkoKuollut() != true
    */
    private void elioidenAktiviteetti(ArrayList<Elio> eliolista) {
        for (int counter = 0; counter < eliolista.size(); counter++) {
            if (!eliolista.get(counter).onkoKuollut()) {
                eliolista.get(counter).olionAktiviteetti();
            }
        }
    }

    /*
    Edistää kasvien tilaa eteenpäin.
    Ottaa vastaan parametrinä listan kasveja.

    AE: onkoKuollut() != true
    */
    private void kasvienAktiviteetti(ArrayList<Kasvi> kasvilista) {
        for (int counter = 0; counter < kasvilista.size(); counter++) {
            if (!kasvilista.get(counter).onkoKuollut()) {
                kasvilista.get(counter).olionAktiviteetti();
            }
        }
    }

    /*
    Edistää kalojen tilaa eteenpäin.
    Ottaa vastaan parametrinä listan kaloja.

    AE: onkoKuollut() != true
    */
    private void kalojenAktiviteetti(ArrayList<Kala> kalalista) {
        for (int counter = 0; counter < kalalista.size(); counter++) {
            if (!kalalista.get(counter).onkoKuollut()) {
                kalalista.get(counter).olionAktiviteetti();
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
            elioidenAktiviteetti(eliöt);
            kasvienAktiviteetti(kasvit);
            kalojenAktiviteetti(kalat);
        }
    }

    public String kalatRaportti() {
        String s = "Kalat vesistössä:\n";
        for (Kala kala : kalat) {
            s += kala.getClass().getSimpleName() + "n koko: " + kala.annettuKoko() + "\n";
            s += "Onko kuollut: " + kala.onkoKuollut() + "\n";
        }
        return s;
    }
    
    public String kasvitRaportti() {
        String s = "Kasvit vesistössä:\n";
        for (Kasvi kasvi : kasvit) {
            s += "Koko: " + kasvi.annettuKoko() + "\n";
            s += "Onko kuollut: " + kasvi.onkoKuollut() + "\n";
        }
        return s;
    }

    public String eliotRaportti() {
        String s = "Eliöt vesistössä:\n";
        for (Elio elio : eliöt) {
            s += elio.getClass().getSimpleName() + "n koko: " + elio.annettuKoko() + "\n";
            s += "Onko kuollut: " + elio.onkoKuollut() + "\n";
        }
        return s;
    }
}
