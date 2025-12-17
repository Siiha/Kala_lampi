package Kala_lampi;

public class Kalastaja {
    /*
    Muuttuja kalastajan valitsemalle vieheelle.
    */
    private Viehe viehe;

    /*
    Muuttuja kalastajan saalisraportille.
    */
    private Saalisraportti raportti;

    /*
    Konstruktori kalastajalle.

    Asettaa kalastajalle perusvieheen sekä saalisraportin.

    AE: true
    */
    public Kalastaja() {
        this.viehe = new Viehe();
        raportti = new Saalisraportti();
    } 

    /*
    Ottaa vastaan parametrinä vieheen, joka asetetaan
    kalastajan nykyiseksi.

    AE: true
    */
    public void valitseViehe(Viehe viehe) {
        this.viehe = viehe;
    }

    public void kalasta() {
        
    }
}
