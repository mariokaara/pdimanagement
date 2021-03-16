import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Tabel tabel = new Tabel();


    public static void main(String[] args) {
	// siia on vaja luua meetodid, mis laseb luua kasutajal uusi auto isendeid ja sisestada nende kohta andmeid
        // kuvab kasutajale kõik auto andmed (lühendatud kujul) ja kasutaja valiku tegemisel kuvab auto täielikud andmed
        //?????
        System.out.println(Menüü.LISA_AUTO.ordinal());


        Scanner valik = new Scanner(System.in);
        int input = valik.nextInt();

        //while loopi sisse
        switch (Menüü.values()[input]) {

            case LISA_AUTO -> {
                lisaAuto();
                break;
            }
            case PRINDI_TABEL -> {
                prindiAuto();
                break;
            }
            case KUSTUTA_AUTO -> {
                kustutaAuto();
                break;
            }

        }
    }
    static void lisaAuto() {
        Scanner kp = new Scanner(System.in);
        LocalDate kuupäev;

        Scanner vin = new Scanner(System.in);
        String vinTähis = vin.nextLine();

        Scanner mk = new Scanner(System.in);
        Enum Mark = ??


        // küsi kasutajalt muutujatesse kõik vajalikud andmed
        //loo uus Auto isend ja lisa tabelisse
        System.out.println("lisa");

    }
    static void kustutaAuto() {
        // tabel.lisaAuto();
        // küsi kasutajalt muutujatesse kõik vajalikud andmed
        //loo uus Auto isend
        System.out.println("kustuta");

    }
    static void prindiAuto() {
        System.out.println("prindi");
    }


}

enum Menüü {
    LISA_AUTO, PRINDI_TABEL, KUSTUTA_AUTO
}
