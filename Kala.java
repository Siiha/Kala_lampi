package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Kala  extends Elio {
    protected ArrayList<Elio> saaliit; // lista mahdollisista eliöistä joita kala voi syödä
    private static double minAlkuKoko = 8.0;
    private static double maxAlkuKoko = 10.0;
    public Kala(double koko, boolean sukupuoli, ArrayList<Elio> saaliit) {
        super(koko, sukupuoli);
        this.saaliit = saaliit;
    }

    private static double arvoElionKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    public static Kala luoKala(ArrayList<Elio> saalislista) {
        Kala eräs = new Kala(arvoElionKoko(), arvoElionSukupuoli(), saalislista);
        return eräs;
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

    public void olionAktiviteetti() {
        syo();
    }
}
    
