package Kala_lampi;
import java.util.ArrayList;
import java.util.Random;
public class Petokala extends Kala {
    private double saalistusTeho;
    public Petokala(double koko, boolean sukupuoli, ArrayList<Elio> saaliit,ArrayList<Kala> Kala_saaliit, double saalistusTeho) {
        super(koko,sukupuoli,saaliit);
        this.saaliit.addAll(Kala_saaliit);
        this.saalistusTeho = saalistusTeho;
    }

    public void saalista(Kala saalis) {
        if (saalis.annettuKoko() < this.saalistusTeho) {
            saalis.kuollut = true;
            this.koko += saalis.annettuKoko() / 100; // Petokala kasvaa syödessään prosentin saaliin koosta
    }
}
}