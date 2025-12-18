package Kala_lampi;

import java.util.ArrayList;
public class Elio implements Kuolevainen{
    protected boolean kuollut=false;
    private double koko;
    private boolean sukupuoli; // true = naaras, false = uros
    protected ArrayList<Kuolevainen> saaliit;
    private static double minAlkuKoko = 5.0;
    private static double maxAlkuKoko = 7.0;

    protected Elio(double koko, boolean sukupuoli, ArrayList<Kuolevainen> saaliit) {
        this.koko = koko;
        this.sukupuoli = sukupuoli;
        this.saaliit = saaliit;
    }

    private static boolean elionSukupuoli() {
        int rng = (int)Math.round(Math.random());
        if (rng == 0) {
            return false;
        }
        return true;
    }

    private static double elionKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    public static Elio luoElio(ArrayList<Kuolevainen> saalisLista) {
        Elio eräs = new Elio(elionKoko(), elionSukupuoli(), saalisLista);
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