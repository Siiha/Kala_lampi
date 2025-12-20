package Kala_lampi;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("Kala-lampi simulaatio alkaa!");
        ArrayList<Elio> saaliit = new ArrayList<>();
        ArrayList<Kala> Kala_saaliit = new ArrayList<>();
        ArrayList<Kasvi> kasvit = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Kasvi kasvi = Kasvi.luoKasvi();
            kasvit.add(kasvi);
        }
        for (int i = 0; i < 5; i++) {
            Petokala petokala = Petokala.luoPetokala(saaliit, Kala_saaliit);
            System.out.println("Luotiin petokala kooltaan: " + petokala.annettuKoko());
        }
        
    }

}
