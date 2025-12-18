package Kala_lampi;
public class Elio {
    public boolean kuollut=false;
    private double koko;
    private boolean sukupuoli; // true = naaras, false = uros
    public Elio(double koko, boolean sukupuoli) {
        this.koko = koko;
        this.sukupuoli = sukupuoli;
    }
    public double annettuKoko() {
        return this.koko;
    }
    public void syo(Kasvi k,double maara) {
        this.koko += k.annettuKoko()/2;
        k.pienene(maara);
    }
}