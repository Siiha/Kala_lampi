package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Petokala extends Kala {
    private static double minAlkuKoko = 12.0;
    private static double maxAlkuKoko = 15.0;
    protected ArrayList<Kala> Kala_saaliit;
    public Petokala(double koko, boolean sukupuoli, ArrayList<Elio> saaliit,ArrayList<Kala> Kala_saaliit) {
        super(koko,sukupuoli,saaliit);
        this.Kala_saaliit = Kala_saaliit;
    }

    private static double arvoElionKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    public static Petokala luoPetokala(ArrayList<Elio> saaliit, ArrayList<Kala> Kala_saaliit) {
        Petokala eräs = new Petokala(arvoElionKoko(), arvoElionSukupuoli(), saaliit, Kala_saaliit);
        return eräs;
    }
    public void syo(){
        int Kks = Kala_saaliit.size();
        if (Kks > 0){
            
            int id = rd.nextInt(Kks); 
            Kala kala = Kala_saaliit.get(id);
            if (kala.annettuKoko() < this.annettuKoko()){
            this.koko += kala.annettuKoko() / 100;
            kala.kuole();
            Kala_saaliit.remove(id);
        }
    }
}
}
