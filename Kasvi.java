
package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Kasvi implements Kuolevainen {
    /*
    Muuttuja kasvin koolle.
    */
    private double koko;

    /*
    Muuttuja kasvin kasvunopeudelle.
    */
    private double kasvuNopeus;

    /*
    Muuttuja kasvin ravinnolle.
    */
    private ArrayList<Kala> ravinto;

    /*
    Muuttuja kasvin kuolleisuuden tilalle.
    */
    private boolean kuollut=false;

    /*
    Muuttuja kasvin minimikoolle.
    */
    private static double minAlkuKoko = 5.0;

    /*
    Muuttuja kasvin maksimikoolle.
    */
    private static double maxAlkuKoko = 7.0;


    /*
    Kasvin konstruktori.
    Ottaa vastaan parametreinä kasvin koon
    ja referenssin ravintolistaan.

    AE: true
    */
    private Kasvi(double koko, ArrayList<Kala> ravinto) {
        this.koko = koko;
        this.ravinto = ravinto;
    }

    /*
    Yrittää kasvattaa kasvin kokoa.

    AE: ravinto.size > 0
    */
    public void kasva() {
        int Kks = ravinto.size();
        if (Kks > 0){
            Random rd = new Random();
            int id = rd.nextInt(Kks); 
            Elio elio = ravinto.get(id);
            this.koko += elio.annettuKoko() / 10;
            ravinto.remove(id);
        }
    }

    /*
    Arpoo kasville aloituskoon.

    AE: true
    */
    private static double arvoKasvinKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    /*
    Luo uuden kasvin ja palauttaa sen.

    AE: true
    */
    public static Kasvi luoKasvi(ArrayList<Kala> ravinto) {
        Kasvi eräs = new Kasvi(arvoKasvinKoko(), ravinto);
        return eräs;
    }

    /*
    Palauttaa kasvin koon.

    AE: true
    */
    public double annettuKoko() {
        return this.koko;
    }

    /*
    Pienentää kasvin kokoa parametrin mukaan.

    AE: onkoKuollut() == false
    */
    public void pienene(double maara) {
        if (onkoKuollut() == false) {
            this.koko -= maara;
            if (this.koko < 0) {
                kuole();
            }
        }
    }

    /*
    Palauttaa kasvin kuolleisuuden tilan.

    AE: true
    */
    public boolean onkoKuollut() {
        return kuollut;
    }

    /*
    Simulaatiolle tarjottu metodi kasvin tilan edistämiseen.

    AE: true
    */
    public void olionAktiviteetti() {
        kasva();
    }

    /*
    Tappaa kasvin.

    AE: onkoKuollut() == false
    */
    public void kuole() {
        if (!onkoKuollut()) {
            kuollut = true;
        }
    }
}