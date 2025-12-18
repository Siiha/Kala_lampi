package Kala_lampi;
public class Kala  extends Elio {
    public Kala(double koko, boolean sukupuoli) {
        super(koko, sukupuoli);
    }
    public void syo(Elio saalis) {
        if (saalis.annettuKoko() < this.annettuKoko()) {
            saalis.kuole();
        }
    }}
    
