package Kala_lampi;

import java.util.ArrayList;
public class Petokala extends Kala {
    private static double minAlkuKoko = 12.0;
    private static double maxAlkuKoko = 15.0;
    private double saalistusTeho;
    public Petokala(double koko, boolean sukupuoli, ArrayList<Kuolevainen> saaliit, ArrayList<Kuolevainen> Kala_saaliit, double saalistusTeho) {
        super(koko,sukupuoli, saaliit);
        this.saaliit.addAll(Kala_saaliit);
        this.saalistusTeho = saalistusTeho;
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

    public static Petokala luoPetokala(ArrayList<Kuolevainen> saalisLista, ArrayList<Kuolevainen> saaliit) {
        Petokala kala = new Petokala(elionKoko(), elionSukupuoli(), saalisLista, saaliit, 10.0);
        return kala;
    }
    public void saalista(Kala saalis) {
        if (saalis.annettuKoko() < this.saalistusTeho) {
            saalis.kuole();
    }
}
}