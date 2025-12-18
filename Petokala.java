package Kala_lampi;
public class Petokala extends Kala {
    private double saalistusTeho;
    public Petokala(double koko, boolean sukupuoli, double saalistusTeho) {
        super(koko,sukupuoli);
        this.saalistusTeho = saalistusTeho;
    }

    public void saalista(Kala saalis) {
        if (saalis.annettuKoko() < this.saalistusTeho) {
            saalis.kuollut = true;
            this.koko += saalis.annettuKoko() / 100; // Petokala kasvaa syödessään prosentin saaliin koosta
    }
}
}