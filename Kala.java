package Kala_lampi;
import Java.util.ArrayList,Java.util.Random;
public class Kala  extends Elio {
    ArrayList<Elio> saaliit; // lista mahdollisista eliöistä joita kala voi syödä
    public Kala(double koko, boolean sukupuoli, ArrayList<Elio> saaliit) {
        super(koko, sukupuoli);
        this.saaliit = saaliit;
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
    
