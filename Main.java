package Kala_lampi;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Elio> saaliit = new ArrayList<Elio>();
        saaliit.add(new Elio(5.0, true));
        saaliit.add(new Elio(3.0, false));
        Kala kala = new Kala(10.0, true, saaliit);
        kala.syo();
        System.out.println("Kalan koko syömisen jälkeen: " + kala.annettuKoko()); 
    }
}