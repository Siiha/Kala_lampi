package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Kala  extends Elio {
    private static Random rd = new Random();
    /*
    Muuttuja kalan mahdollisille saaliille.
    */
    protected ArrayList<Elio> saaliit;

    /*
    Muuttuja kalan minimikoolle.
    */
    private static double minAlkuKoko = 8.0;

    /*
    Muuttuja kalan maksimikoolle.
    */
    private static double maxAlkuKoko = 10.0;

    /*
    Kalan konstruktori.
    Ottaa vastaan parametreinä kalan koon, sukupuolen
    ja referenssin saalislistalle.

    AE: true
    */
    protected Kala(double koko, boolean sukupuoli, ArrayList<Elio> saaliit) {
        super(koko, sukupuoli);
        this.saaliit = saaliit;
    }

    /*
    Arpoo kalalle aloituskoon.

    AE: true
    */
    private static double arvoElionKoko() {
        double koko = minAlkuKoko + (Math.random() * (maxAlkuKoko - minAlkuKoko));
        return Math.round(koko * 10.0) / 10.0;
    }

    /*
    Luo uuden kalan ja palauttaa sen.

    AE: true
    */
    public static Kala luoKala(ArrayList<Elio> saalislista) {
        Kala eräs = new Kala(arvoElionKoko(), arvoElionSukupuoli(), saalislista);
        return eräs;
    }

    /*
    Kala yrittää löytää ja syödä saaliin.

    AE: saaliit.size() > 0
    */
    public void syo() {
        int ss = saaliit.size();
        
        if (ss == 0) {
            return;
        }
        int id = rd.nextInt(ss); 
        Elio saalis = saaliit.get(id);
        if (saalis.annettuKoko() < this.annettuKoko()) {
            saalis.kuole();
            this.koko += saalis.annettuKoko() / 100;
            saaliit.remove(saalis);
        }
    }
}
    
