package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Petokala extends Kala {
    private static double minAlkuKoko = 12.0;
    private static double maxAlkuKoko = 15.0;

    public Petokala(double koko, boolean sukupuoli, ArrayList<Elio> saaliit,ArrayList<Kala> Kala_saaliit) {
        super(koko,sukupuoli,saaliit);
        this.saaliit = Kala_saaliit;
    }

    private static double arvoElionKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    public static Petokala luoPetokala(ArrayList<Elio> saaliit, ArrayList<Kala> Kala_saaliit, double saalistusTeho) {
        Petokala eräs = new Petokala(arvoElionKoko(), arvoElionSukupuoli(), saaliit, Kala_saaliit, saalistusTeho);
        return eräs;
    }
}
