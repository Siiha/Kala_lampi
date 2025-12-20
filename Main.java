package Kala_lampi;

import java.util.Scanner;
public class Main {
    /*
    Muuttuja eliöiden lukumäärälle.
    */
    private static int elioLkm = 0;

    /*
    Muuttuja kasvien lukumäärälle.
    */
    private static int kasviLkm = 0;

    /*
    Muuttuja kalojen lukumäärälle.
    */
    private static int kalaLkm = 0;

    /*
    Muuttuja petokalojen lukumäärälle.
    */
    private static int petokalaLkm = 0;

    /*
    Muuttuja vesistölle.
    */
    private static Vesistö vesistö;

    /*
    Muuttuja lukijalle.
    */
    private static final Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Kala-lampi simulaatio alkaa!");
        pyydaSyotteet();
        vesistö = luoVesisto(elioLkm, kasviLkm, kalaLkm, petokalaLkm);
        int valinta = 10;
        while (valinta != 0) {
            System.out.println("Valitse toiminto:");
            System.out.println("1 - Etene simulaatiota");
            System.out.println("2 - Kalastaja kalastaa");
            System.out.println("3 - Tulosta raportti");
            System.out.println("4 - Nollaa vesistö");
            System.out.println("0 - Lopeta ohjelma");
            String line = lukija.nextLine().trim();
            try {
                valinta = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                valinta = -1;
            }
            switch (valinta) {
                case 1:
                    System.out.println("Kuinka monta kuukautta simulaatio etenee?");
                    int kuukausiMäärä = readPositiveInt("Anna kuukausen määrä: ");
                    vesistö.eteneSimulaatiota(kuukausiMäärä);
                    System.out.println("Simulaatio edennyt " + kuukausiMäärä + " kuukautta.");
                    break;
                case 2:
                    vesistö.kalastajaKalastaa();
                    break;
                case 3:
                    System.out.println(vesistö.kalatRaportti());
                    System.out.println(vesistö.kasvitRaportti());
                    System.out.println(vesistö.eliotRaportti());
                    System.out.println(vesistö.kuolleetRaportti());
                    break;
                case 4:
                    nollaaVesisto();
                    System.out.println("Vesistö nollattu.");
                    break;
                case 0:
                    System.out.println("Lopetetaan ohjelma. Kiitos osallistumisesta!");
                    break;
                default:
                    System.out.println("Virheellinen valinta. Yritä uudelleen.");
            }
        }

    }

    /*
    Luo uuden vesistön saaduilla parametreillä ja palauttaa sen.

    AE: true
    */
    private static Vesistö luoVesisto(int elioLkm, int kasviLkm, int kalaLkm, int petokalaLkm) {
        Vesistö eräs = new Vesistö(elioLkm, kasviLkm, kalaLkm, petokalaLkm);
        return eräs;
    }

    /*
    Nollaa vesistön.

    AE: true
    */
    private static void nollaaVesisto() {
        elioLkm = 0;
        kasviLkm = 0;
        kalaLkm = 0;
        petokalaLkm = 0;
        pyydaSyotteet();
        vesistö = luoVesisto(elioLkm, kasviLkm, kalaLkm, petokalaLkm);
    }

    /*
    Pyytää käyttäjältä syötteet eliöille, kasveille, kaloille ja petokaloille.

    AE: true
    */
    private static void pyydaSyotteet() {
        elioLkm = readPositiveInt("Anna eliöiden lukumäärä: ");
        kasviLkm = readPositiveInt("Anna kasvien lukumäärä: ");
        kalaLkm = readPositiveInt("Anna kalojen lukumäärä: ");
        petokalaLkm = readPositiveInt("Anna petokalojen lukumäärä: ");
    }

    /*
    Apumetodi lukijalle.

    AE: true
    */
    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String line = lukija.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val > 0) return val;
                System.out.println("Syötä positiivinen kokonaisluku.");
            } catch (NumberFormatException e) {
                System.out.println("Virheellinen syöte. Yritä uudelleen.");
            }
        }
    }
}
