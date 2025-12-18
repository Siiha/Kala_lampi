package Kala_lampi;

import java.util.ArrayList;
import java.util.Random;
public class Kala  extends Elio {

    private static double minAlkuKoko = 8.0;
    private static double maxAlkuKoko = 10.0;
    
    protected Kala(double koko, boolean sukupuoli, ArrayList<Kuolevainen> saaliit) {
        super(koko, sukupuoli, saaliit);
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

    public static Kala luoKala(ArrayList<Kuolevainen> saalisLista) {
        Kala kala = new Kala(elionKoko(), elionSukupuoli(), saalisLista);
        return kala;
    }

    public void syo(Elio saalis) {
        if (saalis.annettuKoko() < this.annettuKoko()) {
            saalis.kuole();
        }
    }

    public void syo() {
        int ss = saaliit.size();
        Random rd = new Random();
        if (ss == 0) {
            return;
        }
        int id = rd.nextInt(ss); 
        Elio saalis = saaliit.get(id);
        if (saalis.annettuKoko() < this.annettuKoko()) {
            saalis.kuollut=true;
            this.koko += saalis.annettuKoko() / 100;
        }
    }
}
    
