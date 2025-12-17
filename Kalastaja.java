package Kala_lampi;

public class Kalastaja {
    /*
    Muuttuja kalastajan valitsemalle vieheelle.
    */
    private Viehe viehe;

    /*
    Konstruktori kalastajalle.

    Asettaa kalastajalle perusvieheen.

    AE: true
    */
    public Kalastaja() {
        this.viehe = new Viehe();
    } 

    /*
    Ottaa vastaan parametrinä vieheen, joka asetetaan
    kalastajan vieheeksi.

    AE: true
    */
    public void valitseViehe(Viehe viehe) {
        this.viehe = viehe;
    }
}
