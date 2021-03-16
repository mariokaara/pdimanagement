import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Tabel tabel = new Tabel();


    public static void main(String[] args) {
	// siia on vaja luua meetodid, mis laseb luua kasutajal uusi auto isendeid ja sisestada nende kohta andmeid
        // kuvab kasutajale kõik auto andmed (lühendatud kujul) ja kasutaja valiku tegemisel kuvab auto täielikud andmed
        //?????
        System.out.println("Auto lisamiseks vali " + Menüü.LISA_AUTO.ordinal());
        System.out.println("Tabeli printimiseks vali " + Menüü.PRINDI_TABEL.ordinal());
        System.out.println("Auto kustutamiseks vali " + Menüü.KUSTUTA_AUTO.ordinal());


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
        System.out.println(tabel.toString());
    }
    static void lisaAuto() {
        LocalDate kuupäev = LocalDate.now();

        Scanner vin = new Scanner(System.in);
        System.out.println("Sisesta VIN tähis: ");
        String vinTähis = vin.nextLine();

        Scanner mk = new Scanner(System.in);
        System.out.println("Sisesta auto mark: ");
        String mark = mk.nextLine();

        Scanner mdl = new Scanner(System.in);
        System.out.println("Sisesta auto mudel: ");
        String mudel = mdl.nextLine();

        Scanner klnt = new Scanner(System.in);
        System.out.println("Sisesta kliendi nimi: ");
        String klient= klnt.nextLine();

        Scanner ak = new Scanner(System.in);
        System.out.println("Sisesta auto asukoht: ");
        String asukoht = ak.nextLine();

        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Auto uusAuto = new Auto(kuupäev, vinTähis, mark, mudel, klient, asukoht, töödeNimekiri);

        tabel.lisaAuto(uusAuto);

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
