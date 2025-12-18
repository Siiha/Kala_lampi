package Kala_lampi;

import java.util.ArrayList;
public class Petokala extends Kala {
    private static double minAlkuKoko = 12.0;
    private static double maxAlkuKoko = 15.0;
    private double saalistusTeho = 10.0;
    public Petokala(double koko, boolean sukupuoli, double saalistusTeho, ArrayList<Kuolevainen> saaliit) {
        super(koko,sukupuoli, saaliit);
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

    public static Petokala luoPetokala(ArrayList<Kuolevainen> saalisLista) {
        Petokala kala = new Petokala(elionKoko(), elionSukupuoli(), 10.0,  saalisLista);
        return kala;
    }
    public void saalista(Kala saalis) {
        if (saalis.annettuKoko() < this.saalistusTeho) {
            saalis.kuole();
    }
}
}