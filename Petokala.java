package Kala_lampi;
public class Petokala extends Kala {
    private double saalistusTeho;
    public Petokala(double koko, double saalistusTeho) {
        super(koko);
        this.saalistusTeho = saalistusTeho;
    }

    public void saalista(Kala saalis) {
        if (saalis.annettuKoko() < this.saalistusTeho) {
            saalis.kuole();
    }
}
}