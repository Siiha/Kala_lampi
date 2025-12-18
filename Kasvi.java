package Kala_lampi;
public class Kasvi implements Kuolevainen{
    private double koko;
    private double kasvuNopeus;
    private boolean kuollut=false; 
    public Kasvi(double koko) {
        this.koko = koko;
    }
    public void kasva() {
        this.koko += kasvuNopeus;
    }
    public double annettuKoko() {
        return this.koko;
    }
    public void pienene(double maara) {
        this.koko -= maara;
        if (this.koko < 0) {
            kuole();
        }
    }
    public boolean onkoKuollut() {
        return kuollut;
    }
    public void olionAktiviteetti() {
        
    }
    public void kuole() {
        if (kuollut == false) {
            kuollut = true;
        }
    }
}