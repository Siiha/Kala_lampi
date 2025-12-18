package Kala_lampi;
public class Elio implements Kuolevainen{
    protected boolean kuollut=false;
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