package Kala_lampi;

import java.util.Scanner;
public class Main {

    private static int elioLkm = 0;
    private static int kasviLkm = 0;
    private static int kalaLkm = 0;
    private static int petokalaLkm = 0;
    private static Vesistö vesistö;

    private static final Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Kala-lampi simulaatio alkaa!");
        pyydaSyotteet();
        vesistö = luoVesisto(elioLkm, kasviLkm, kalaLkm, petokalaLkm);

    }

    private static Vesistö luoVesisto(int elioLkm, int kasviLkm, int kalaLkm, int petokalaLkm) {
        Vesistö eräs = new Vesistö(elioLkm, kasviLkm, kalaLkm, petokalaLkm);
        return eräs;
    }

    private static void nollaaVesisto() {
        elioLkm = 0;
        kasviLkm = 0;
        kalaLkm = 0;
        petokalaLkm = 0;
        pyydaSyotteet();
        vesistö = luoVesisto(elioLkm, kasviLkm, kalaLkm, petokalaLkm);
    }

    private static void pyydaSyotteet() {
        elioLkm = readPositiveInt("Anna eliöiden lukumäärä:");
        kasviLkm = readPositiveInt("Anna kasvien lukumäärä:");
        kalaLkm = readPositiveInt("Anna kalojen lukumäärä:");
        petokalaLkm = readPositiveInt("Anna petokalojen lukumäärä:");
    }

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
