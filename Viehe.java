package Kala_lampi;

public class Viehe {
    /*
    Todennäköisyys saaliskalan kiinnijäämiseen.
    */
    private int saaliskalaChance;
    /*
    Todennäköisyys petokalan kiinnijäämiseen.
    */
    private int petokalaChance;

    /*
    Vieheen konstruktori.

    Asettaa vieheelle kalan kiinnijäämisen todennäköisyydet.

    AE: true
    */
    public Viehe() {
        saaliskalaChance = 40;
        petokalaChance = 40;
    }

    /*
    Tarkistaa jäikö kala kiinni vieheeseen.
    Saa tarkistettavan kalan parametrinä.

    AE: eräsKala != null
    */
    public boolean jaikoKiinni(Kala eräsKala) {
        if (eräsKala != null) {
            int rng = (int)(Math.random() * 101);
            if (eräsKala.getClass().getSimpleName().equals("Petokala")) {
                if (rng >= petokalaChance) {
                    return true;
                }
            } else {
                if (rng >= saaliskalaChance) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
