
package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Kasvi implements Kuolevainen {
    private double koko;
    private double kasvuNopeus;
    private boolean kuollut=false;
    private static double minAlkuKoko = 5.0;
    private static double maxAlkuKoko = 7.0;
    public Kasvi(double koko) {
        this.koko = koko;
    }
    public void kasva(ArrayList<Kala> Kuolleet) {
        int Kks = Kuolleet.size();
        if (Kks > 0){
            Random rd = new Random();
            int id = rd.nextInt(Kks); 
            Elio elio = Kuolleet.get(id);
            this.koko += elio.annettuKoko() / 10;
            Kuolleet.remove(id);
        }
    }

    private static double arvoKasvinKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    public static Kasvi luoKasvi() {
        Kasvi eräs = new Kasvi(arvoKasvinKoko());
        return eräs;
    }

    public double annettuKoko() {
        return this.koko;
    }
    public void pienene(double maara) {
        this.koko -= maara;
        if (this.koko < 0) {
            kuole();
        }
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