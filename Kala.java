package Kala_lampi;
public class Kala  extends elio {
    public Kala(double koko) {
        super();
    }
    public void syo(elio saalis) {
        if (saalis.annettuKoko() < this.annettuKoko()) {
            saalis.kuollut=true;
        }
    }}
    
