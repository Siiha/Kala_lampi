package Kala_lampi;
public class Elio {
    public boolean kuollut=false;
    private double koko;
    public Elio(double koko) {
        this.koko = koko;
    }
    public double annettuKoko() {
        return this.koko;
    }
    public void syo(Kasvi k,double maara) {
        this.koko += k.annettuKoko()/2;
        k.pienene(maara);
    }
}