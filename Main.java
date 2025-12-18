package Kala_lampi;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Elio> saaliit = new ArrayList<Elio>();
        saaliit.add(new Elio(5.0, true));
        saaliit.add(new Elio(3.0, false));
        Kala kala = new Kala(10.0, true, saaliit);
        Petokala petoKala = new Petokala(15.0, false, saaliit, new ArrayList<Kala>(), 4.0);
        petoKala.syo();
        System.out.println("PetoKalan koko syömisen jälkeen: " + petoKala.annettuKoko());
    }
}