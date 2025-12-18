
package Kala_lampi;
import Java.util.ArrayList,Java.util.Random;
public class Kasvi {
    private double koko;
    private double kasvuNopeus;
    private boolean kuollut=false;
    public Kasvi(double koko) {
        this.koko = koko;
    }
    public void kasva(ArrayList<Kala> Kuolleet_kalat) {
        int Kks = Kuolleet_kalat.size();
        if (Kks > 0){
            Random rd = new Random();
            int id = rd.nextInt(Kks); 
            Kala kala = Kuolleet_kalat.get(id);
            this.koko += kala.annettuKoko() / 10;
            Kuolleet_kalat.remove(id);
        }
    }
    public double annettuKoko() {
        return this.koko;
    }
    public void pienene(double maara) {
        this.koko -= maara;
        if (this.koko < 0) {
            this.kuollut = true;
        }
    }
}