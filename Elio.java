package Kala_lampi;

import java.util.ArrayList;

public class Elio implements Kuolevainen {
    public boolean kuollut=false;
    protected double koko;
    protected boolean sukupuoli; // true = naaras, false = uros
    private ArrayList<Kasvi> saaliit;
    private static double minAlkuKoko = 5.0;
    private static double maxAlkuKoko = 7.0;

    public Elio(double koko, boolean sukupuoli) {
        this.koko = koko;
        this.sukupuoli = sukupuoli;
    }

    public void asetaSaaliit(ArrayList<Kasvi> saaliit) {
        this.saaliit = saaliit;
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
    public void syo(Kasvi k,double maara) {
        this.koko += k.annettuKoko()/2;
        k.pienene(maara);
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