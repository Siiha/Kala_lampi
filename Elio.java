package Kala_lampi;

import java.util.ArrayList;
import java.util.Random;
public class Elio implements Kuolevainen {
    protected boolean kuollut=false;
    protected double koko;
    protected boolean sukupuoli; // true = naaras, false = uros
    protected Random rd = new Random(); 
    private ArrayList<Kasvi> kasvit;
    private static double minAlkuKoko = 5.0;
    private static double maxAlkuKoko = 7.0;

    protected Elio(double koko, boolean sukupuoli) {
        this.koko = koko;
        this.sukupuoli = sukupuoli;
    }

    public void asetaKasvit(ArrayList<Kasvi> kasvit) {
        this.kasvit = kasvit;
    }

    protected static boolean arvoElionSukupuoli() {
        int rng = (int)Math.round(Math.random());
        if (rng == 0) {
            return false;
        }
        return true;
    }

    private static double arvoElionKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    public static Elio luoElio() {
        Elio eräs = new Elio(arvoElionKoko(), arvoElionSukupuoli());
        return eräs;
    }

    public double annettuKoko() {
        return this.koko;
    }

    public boolean onkoNaaras() {
        return this.sukupuoli;
    }

    public void syo() {
        Kasvi k = kasvit.get(rd.nextInt(kasvit.size()));
        this.koko += k.annettuKoko()/2;
        k.pienene(1.0);
    }
    public boolean onkoKuollut() {
        return kuollut;
    }
    public void olionAktiviteetti() {

    }
    public void kuole() {
        if (kuollut == false) {
            kuollut = true;
        }
    }
}