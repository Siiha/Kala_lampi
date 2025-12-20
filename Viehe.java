package Kala_lampi;
import java.util.Random;
public class Viehe {
    private static Random rd = new Random();
    /*
    Todennäköisyys saaliskalan ja petokalan kiinnijäämiseen.
    */
    protected int saaliskalaChance,petokalaChance;
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
            int rng = rd.nextInt(100) + 1;
            if (eräsKala.getClass().getSimpleName().equals("Petokala")) {
                if (rng <= petokalaChance) {
                    return true;
                }
            } else {
                if (rng <= saaliskalaChance) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
