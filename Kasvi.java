
package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Kasvi implements Kuolevainen {
    private double koko;
    private double kasvuNopeus;
    private boolean kuollut=false;
    public Kasvi(double koko) {
        this.koko = koko;
    }
    public void kasva(ArrayList<Elio> Kuolleet) {
        int Kks = Kuolleet.size();
        if (Kks > 0){
            Random rd = new Random();
            int id = rd.nextInt(Kks); 
            Elio elio = Kuolleet.get(id);
            this.koko += elio.annettuKoko() / 10;
            Kuolleet.remove(id);
        }
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