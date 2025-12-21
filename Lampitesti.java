package Kala_lampi;

import java.util.ArrayList;

public class Lampitesti {
    public static void main(String[] args) {
        ArrayList<Kasvi> kasvit = new ArrayList<>();
        ArrayList<Elio> eliot = new ArrayList<>();
        ArrayList<Kala> kalat = new ArrayList<>();
        Kalastaja kalastaja = new Kalastaja();

        Vesistö lampi1 = new Vesistö(0, 2, 2, 2);
        Vesistö lampi2 = new Vesistö(2, 0, 2, 2);
        Vesistö lampi3 = new Vesistö(2, 2, 0, 2);
        Vesistö lampi4 = new Vesistö(2, 2, 2, 0);
        Vesistö tyhjälampi = new Vesistö(0, 0, 0, 0);

        lampi1.eteneSimulaatiota(1);
        lampi2.eteneSimulaatiota(1);
        lampi3.eteneSimulaatiota(1);
        lampi4.eteneSimulaatiota(1);
        tyhjälampi.eteneSimulaatiota(1);

        Kasvi kasvi1 = Kasvi.luoKasvi(kalat);
        kasvit.add(kasvi1);
        Elio elio1 = Elio.luoElio();
        elio1.asetaKasvit(kasvit);
        eliot.add(elio1);
        Kala kala1 = Kala.luoKala(eliot);
        kalat.add(kala1);
        Petokala peto1 = Petokala.luoPetokala(eliot, kalat);
        kalat.add(peto1);

        kalastaja.kalasta(kalat);
        System.out.println(kalastaja.haeRaportti());
        
        kalat.remove(kala1);
        kalat.remove(peto1);
        kalastaja.kalasta(kalat);
        System.out.println(kalastaja.haeRaportti());

    }
}
