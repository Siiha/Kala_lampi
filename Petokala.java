package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Petokala extends Kala {
    /*
    Muuttuja satunnaislukugeneraattorille.
    */
    private static Random rd = new Random();

    /*
    Muuttuja petokalan minimikoolle.
    */
    private static double minAlkuKoko = 12.0;

    /*
    Muuttuja petokalan maksimikoolle.
    */
    private static double maxAlkuKoko = 15.0;

    /*
    Muuttuja petokalan mahdollisille saaliille.
    */
    protected ArrayList<Kala> Kala_saaliit;

    /*
    Petokalan konstruktori.
    Ottaa vastaan parametreinä petokalan koon, sukupuolen
    ja referenssin saalislistalle.

    AE: true
    */
    protected Petokala(double koko, boolean sukupuoli, ArrayList<Elio> saaliit,ArrayList<Kala> Kala_saaliit) {
        super(koko,sukupuoli,saaliit);
        this.Kala_saaliit = Kala_saaliit;
    }

    /*
    Arpoo petokalan aloituskoon.

    AE: true
    */
    private static double arvoElionKoko() {
        double koko = minAlkuKoko + (rd.nextDouble() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    /*
    Luo uuden petokalan ja palauttaa sen.

    AE: true
    */
    public static Petokala luoPetokala(ArrayList<Elio> saaliit, ArrayList<Kala> Kala_saaliit) {
        Petokala eräs = new Petokala(arvoElionKoko(), arvoElionSukupuoli(), saaliit, Kala_saaliit);
        return eräs;
    }

    /*
    Petokala yrittää löytää ja syödä saaliin.

    AE: Kala_saaliit.size() > 0
    */
    public void syo(){
        int Kks = Kala_saaliit.size();
        if (Kks > 0){
            
            int id = rd.nextInt(Kks); 
            Kala kala = Kala_saaliit.get(id);
            if (kala.annettuKoko() < this.annettuKoko()){
            this.koko += kala.annettuKoko() / 100;
            kala.kuole();
        }
    }
}
}
