package Kala_lampi;

import java.util.ArrayList;
import java.util.Random;
public class Vesistö {
    /*
    Muuttuja satunnaislukugeneraattorille.
    */
    private static Random rd = new Random();
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
    Muuttuja kuolleille kaloille.
    */
    private ArrayList<Kala> kuolleetKalat;

    /*
    Muuttuja kalastajalle.
    */
    private Kalastaja kalastaja;

    /*
    Muuttuja simulaation kuluneelle ajalle.
    Käytetään lisääntymisen seurantaan.
    */
    private int kulunutAika = 0;

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
        kuolleetKalat = new ArrayList<>();
        kalastaja = new Kalastaja();
        
        for (int counter = 0; counter < elio; counter++) {
            Elio eräs = Elio.luoElio();
            eräs.asetaKasvit(kasvit);
            eliöt.add(eräs);
        }

        for (int counter = 0; counter < kasvi; counter++) {
            Kasvi eräs = Kasvi.luoKasvi(kuolleetKalat);
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

    AE: eliolista != null && onkoKuollut() == false
    */
    private void elioidenAktiviteetti(ArrayList<Elio> eliolista) {
        if (eliolista != null) {
            for (int counter = 0; counter < eliolista.size(); counter++) {
                if (!eliolista.get(counter).onkoKuollut()) {
                    eliolista.get(counter).olionAktiviteetti();
                }
        }
        }

    }

    /*
    Edistää kasvien tilaa eteenpäin.
    Ottaa vastaan parametrinä listan kasveja.

    AE: kasvilista != null && onkoKuollut() == false
    */
    private void kasvienAktiviteetti(ArrayList<Kasvi> kasvilista) {
        if (kasvilista != null) {
            for (int counter = 0; counter < kasvilista.size(); counter++) {
                if (!kasvilista.get(counter).onkoKuollut()) {
                    kasvilista.get(counter).olionAktiviteetti();
                }
        }
        }

    }

    /*
    Edistää kalojen tilaa eteenpäin.
    Ottaa vastaan parametrinä listan kaloja.

    AE: kalalista != null
    */
   
    private void kalojenAktiviteetti(ArrayList<Kala> kalalista) {
        if (kalalista != null) {
            for (int counter = 0; counter < kalalista.size(); counter++) {
                Kala eräs = kalalista.get(counter);
                if (!eräs.onkoKuollut()) {
                    eräs.olionAktiviteetti();
                } else {
                    kuolleetKalat.add(eräs);
                    kalalista.remove(eräs);
                }
            }
        }  
    }

    /*
    Luo uusia eliöitä vesistöön.

    AE: true
    */
   private int random100() {
        return rd.nextInt(100);
    }
    private void elioLisaantyminen() {
        int urosLkm = 0;
        int naarasLkm = 0;
        int lisaantyminenTodennäkoisyys = 50;

        for (Elio elio : eliöt) {
            if (!elio.onkoKuollut()) {
                if (elio.onkoNaaras()) {
                    naarasLkm++;
                } else {
                    urosLkm++;
                }
            }
        }
        int parit = Math.min(urosLkm, naarasLkm);
        for (int counter = 0; counter < parit; counter++) {
            int rng = random100();
            if (rng < lisaantyminenTodennäkoisyys) {
                Elio eräs = Elio.luoElio();
                eräs.asetaKasvit(kasvit);
                eliöt.add(eräs);
            }
        }
    }

    /*
    Lisää uusia kaloja vesistöön.

    AE: true
    */
    private void kalaLisaantyminen() {
        int urosLkm = 0;
        int naarasLkm = 0;
        int lisaantyminenTodennäkoisyys = 30;

        for (Kala kala : kalat) {
            if (kala instanceof Petokala) {
                continue;
            }
            if (!kala.onkoKuollut()) {
                if (kala.onkoNaaras()) {
                    naarasLkm++;
                } else {
                    urosLkm++;
                }
            }
        }
        int parit = Math.min(urosLkm, naarasLkm);
        for (int counter = 0; counter < parit; counter++) {
            int rng = random100();
            if (rng < lisaantyminenTodennäkoisyys) {
                Kala eräs = Kala.luoKala(eliöt);
                kalat.add(eräs);
            }
        }
        
    }

    /*
    Lisää uusia petokaloja vesistöön.

    AE: true
    */
    private void petokalaLisaantyminen() {
        int urosLkm = 0;
        int naarasLkm = 0;
        int lisaantyminenTodennäkoisyys = 20;

        for (Kala kala : kalat) {
            if (kala instanceof Petokala) {
                if (!kala.onkoKuollut()) {
                    if (kala.onkoNaaras()) {
                        naarasLkm++;
                    } else {
                        urosLkm++;
                    }
                }
            }
        }
        int parit = Math.min(urosLkm, naarasLkm);
        for (int counter = 0; counter < parit; counter++) {
            int rng = random100();
            if (rng < lisaantyminenTodennäkoisyys) {
                Petokala eräs = Petokala.luoPetokala(eliöt, kalat);
                kalat.add(eräs);
            }
        }
        
    }

    /*
    Yrittää lisätä uusia eliöitä vesistöön.

    AE: kulunutAika >= 12
    */
    private void lisaantyminen() {
        if (kulunutAika >= 12) {
            while (kulunutAika >= 12) {
                elioLisaantyminen();
                kalaLisaantyminen();
                petokalaLisaantyminen();
                kulunutAika -= 12;
            }
        }
    }

    /*
    Simulaatio siirtyy eteenpäin.
    
    Ottaa vastaan parametrinä kuukausien määrän.

    AE: true
    */
    public void eteneSimulaatiota(int kuukausiMäärä) {
        kulunutAika += kuukausiMäärä;
        for (int counter = 0; counter < kuukausiMäärä; counter++) {
            elioidenAktiviteetti(eliöt);
            kasvienAktiviteetti(kasvit);
            kalojenAktiviteetti(kalat);
            lisaantyminen();
        }
    }

    /*
    Kalastaja yrittää kalastaa vesistöstä.

    AE: true
    */
    public void kalastajaKalastaa() {
        kalastaja.kalasta(kalat);
        kalastaja.kalasta(kalat);
        System.out.println(kalastaja.haeRaportti());
    }

    /*
    Asettaa kalastajalle parametrina saadun vieheen.

    AE: viehe != null
    */
    public void asetaViehe(Viehe viehe) {
        if (viehe != null) {
            kalastaja.valitseViehe(viehe);
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

    public String kuolleetRaportti() {
        String s = "Kuolleet kalat vesistössä:\n";
        for (Kala kala : kuolleetKalat) {
            s += kala.getClass().getSimpleName() + "n koko: " + kala.annettuKoko() + "\n";
        }
        return s;
    }
}
