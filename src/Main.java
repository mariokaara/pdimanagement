import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Tabel mäluTabel = new MäluTabel();


    public static void main(String[] args) throws IOException, ClassNotFoundException {


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
                prindiTabel();
                break;
            }
            case KUSTUTA_AUTO -> {
                kustutaAuto();
                break;
            }

        }
        System.out.println(mäluTabel.toString());


    }

    static void lisaAuto() {

        Scanner sisend = new Scanner(System.in);

        System.out.println("Sisesta kuupäev formaadis YYYY-MM-DD: ");
        String kuupäev = sisend.nextLine();
        LocalDate loomiseKuupäev = LocalDate.now();

        if (kuupäev.length() != 0) {
            loomiseKuupäev = LocalDate.parse(kuupäev);
        }

        System.out.println("Sisesta VIN tähis: ");
        String vinTähis = sisend.nextLine();

        System.out.println("Sisesta auto mark: ");
        String mark = sisend.nextLine();

        System.out.println("Sisesta auto mudel: ");
        String mudel = sisend.nextLine();

        System.out.println("Sisesta kliendi nimi: ");
        String klient = sisend.nextLine();

        System.out.println("Sisesta auto asukoht: ");
        String asukoht = sisend.nextLine();

        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Auto uusAuto = new Auto(loomiseKuupäev, vinTähis, mark, mudel, klient, asukoht, töödeNimekiri);

        mäluTabel.lisaAuto(uusAuto);

    }

    static void kustutaAuto() {

    }


    static void prindiTabel() {
        System.out.println("prindi");
    }
}

enum Menüü {
    LISA_AUTO, PRINDI_TABEL, KUSTUTA_AUTO
}