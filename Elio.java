package Kala_lampi;

import java.util.ArrayList;
import java.util.Random;
public class Elio implements Kuolevainen {
    /*
    Muuttuja eliön kuolleisuuden tilalle.
    */
    protected boolean kuollut=false;

    /*
    Muuttuja eliön koolle.
    */
    protected double koko;

    /*
    Muuttuja eliön sukupuolelle.
    true = naaras, false = uros
    */
    protected boolean sukupuoli;

    /*
    Muuttuja eliön satunnaislukugeneraattorille.
    */
    protected Random rd = new Random();

    /*
    Muuttuja kasvien listalle.
    */
    private ArrayList<Kasvi> kasvit;

    /*
    Muuttuja eliön minimikoolle.
    */
    private static double minAlkuKoko = 5.0;

    /*
    Muuttuja eliön maksimikoolle.
    */
    private static double maxAlkuKoko = 7.0;

    /*
    Eliön konstruktori.
    Ottaa vastaan parametreinä eliön koon ja sukupuolen.

    AE: true
    */
    protected Elio(double koko, boolean sukupuoli) {
        this.koko = koko;
        this.sukupuoli = sukupuoli;
    }

    /*
    Asettaa eliölle kasvien listan.

    AE: true
    */
    public void asetaKasvit(ArrayList<Kasvi> kasvit) {
        this.kasvit = kasvit;
    }

    /*
    Arpoo eliölle sukupuolen.

    AE: true
    */
    protected static boolean arvoElionSukupuoli() {
        int rng = (int)Math.round(Math.random());
        if (rng == 0) {
            return false;
        }
        return true;
    }

    /*
    Arpoo eliölle aloituskoon.

    AE: true
    */
    private static double arvoElionKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    /*
    Luo uuden eliön ja palauttaa sen.

    AE: true
    */
    public static Elio luoElio() {
        Elio eräs = new Elio(arvoElionKoko(), arvoElionSukupuoli());
        return eräs;
    }

    /*
    Palauttaa eliön koon.

    AE: true
    */
    public double annettuKoko() {
        return this.koko;
    }

    /*
    Palauttaa true jos eliö on naaras, false jos uros.

    AE: true
    */
    public boolean onkoNaaras() {
        return this.sukupuoli;
    }

    /*
    Syö kasvia kasvilistasta.

    AE: true
    */
    public void syo() {
        Kasvi k = kasvit.get(rd.nextInt(kasvit.size()));
        this.koko += k.annettuKoko()/2;
        k.pienene(1.0);
    }

    /*
    Palauttaa eliön kuolleisuuden tilan.

    AE: true
    */
    public boolean onkoKuollut() {
        return kuollut;
    }

    /*
    Simulaatiolle tarjottu metodi eliön tilan edistämiseen.
    */
    public void olionAktiviteetti() {
        syo();
    }

    /*
    Tappaa eliön.

    AE: onkoKuollut() == false
    */
    public void kuole() {
        if (!onkoKuollut()) {
            kuollut = true;
        }
    }
}