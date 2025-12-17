package Kala_lampi;
public class Kala  extends Elio {
    public Kala() {
    }
    public void syo(Elio saalis) {
        if (saalis.annettuKoko() < this.annettuKoko()) {
            saalis.kuollut=true;
        }
    }}
    
