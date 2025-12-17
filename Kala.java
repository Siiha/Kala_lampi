package Kala_lampi;
public class Kala  extends Elio {
    private double koko;
    public Kala(double koko) {
        this.koko = koko;
    }
    public void syo(Elio saalis) {
        if (saalis.annettuKoko() < this.annettuKoko()) {
            saalis.kuollut=true;
        }
    }}
    
