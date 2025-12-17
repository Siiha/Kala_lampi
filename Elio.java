package Kala_lampi;
public class elio {
    private double koko;
    public elio(double koko) {
        this.koko = koko;
    }
    public double annettuKoko() {
        return this.koko;
    }
    public void kuole() {
        this.koko = 0;
        
    }
    public void syo(Kasvi k,double maara) {
        this.koko += k.annettuKoko();
        k.pienene(maara);
    }
}