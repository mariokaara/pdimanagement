import java.util.Scanner;

public class Main {
    static Tabel tabel = new Tabel();


    public static void main(String[] args) {
	// siia on vaja luua meetodid, mis laseb luua kasutajal uusi auto isendeid ja sisestada nende kohta andmeid
        // kuvab kasutajale kõik auto andmed (lühendatud kujul) ja kasutaja valiku tegemisel kuvab auto täielikud andmed
        //?????
        System.out.println(Menüü.LISA_AUTO.ordinal());

        int valik = 1; //kasutaja sisestab

        //while loopi sisse
        switch (Menüü.values()[valik]) {

            case LISA_AUTO -> {
                lisaAuto();
                break;
            }
            case PRINDI_TABEL -> {
                prindiAuto();
                break;
            }
        }
    }
    static void lisaAuto() {
        tabel.lisAuto();
        // küsi kasutajalt muutujatesse kõik vajalikud andmed
        //loo uus Auto isend

    }
    static void prindiAuto() {

    }


}

enum Menüü {
    LISA_AUTO, PRINDI_TABEL
}
