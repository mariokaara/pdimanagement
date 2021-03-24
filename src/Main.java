import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Tabel mäluTabel = new MäluTabel();
    static Tabel failiTabel = new FailiTabel("autod.txt");
    static Tabel tabel = failiTabel;

    public static void main(String[] args) {

        System.out.println("****************************************************************************");
        System.out.println("*        Tere tulemast autode müügiks ettevalmistamise infosüsteemi!       *");
        System.out.println("*                    autorid: Mario Käära ja Raivo Kasepuu                 *");
        System.out.println("*                                 MVP edition 1.0                          *");
        System.out.println("****************************************************************************");

        System.out.println("Auto lisamiseks vali: " + Menüü.LISA_AUTO.ordinal());
        System.out.println("Tabeli printimiseks vali: " + Menüü.PRINDI_TABEL.ordinal());
        System.out.println("Auto kustutamiseks vali: " + Menüü.KUSTUTA_AUTO.ordinal());
        System.out.println("Vali tabeli implementatsioon. 1 - mälutabel või 2 - failitabel: " + Menüü.VALI_TABEL.ordinal());
        System.out.println("Väljumiseks vali: " + Menüü.MENÜÜST_VÄLJA.ordinal());


        Scanner valik = new Scanner(System.in);


        loop:
        while (true) {
            System.out.print("Tee valik: ");

            int input = valik.nextInt();
            switch (Menüü.values()[input]) {

                case LISA_AUTO -> {
                    lisaAutoMenüü();
                    break;
                }
                case PRINDI_TABEL -> {
                    prindiTabelMenüü();
                    break;
                }
                case KUSTUTA_AUTO -> {
                    kustutaAutoMenüü();
                    break;
                }

                case VALI_TABEL -> {
                    valiTabel();
                    break;
                }
                case MENÜÜST_VÄLJA -> {
                    break loop;
                }

            }
        }


    }

    private static void valiTabel() {
        Scanner sisend = new Scanner(System.in);

        if (sisend.nextInt() == 1) {
            tabel = mäluTabel;
        } else {
            tabel = failiTabel;
        }
    }

    static void lisaAutoMenüü() {

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

        System.out.println("Sisesta tööd: ");
        String töödeNimekiri = sisend.nextLine();

        Auto uusAuto = new Auto(loomiseKuupäev, vinTähis, mark, mudel, klient, asukoht, töödeNimekiri);

        tabel.lisaAuto(uusAuto);

        System.out.println("Uus töö edukalt sisestatud!");

    }


    static void kustutaAutoMenüü() {
        System.out.print("Sisesta auto rea nr: ");
        Scanner sc = new Scanner(System.in);
        int reaNr = sc.nextInt();
        if (tabel.kustutaAuto(reaNr)) {
            System.out.println("Auto realt nr " + reaNr + " kustutatud!");
        } else {
            System.out.println("Auto eemaldamine ebaõnnestus. Kontrolli rea numberit!");
        }

    }


    static void prindiTabelMenüü() {
        System.out.println(tabel.prindiTabel());
    }
}

enum Menüü {
    LISA_AUTO, PRINDI_TABEL, KUSTUTA_AUTO, MENÜÜST_VÄLJA, VALI_TABEL
}