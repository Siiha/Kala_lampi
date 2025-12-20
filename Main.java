package Kala_lampi;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("Kala-lampi simulaatio alkaa!");
        ArrayList<Kala> kalat = new ArrayList<>();
        ArrayList<Kasvi> kasvit = new ArrayList<>();
        ArrayList<Elio> eliot = new ArrayList<>();
        ArrayList<Petokala> petokalat = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Petokala peto = Petokala.luoPetokala(eliot, kalat);
            petokalat.add(peto);
        }
        for (Petokala peto : petokalat) {
            System.out.println("Petokalan koko: " + peto.annettuKoko());
        }   
    }

}
