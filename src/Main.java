import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //static Tabel tabel = new MäluTabel();
    static Tabel tabel = new FailiTabel("autod.txt");


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Auto lisamiseks vali: " + Menüü.LISA_AUTO.ordinal());
        System.out.println("Tabeli printimiseks vali: " + Menüü.PRINDI_TABEL.ordinal());
        System.out.println("Auto kustutamiseks vali: " + Menüü.KUSTUTA_AUTO.ordinal());
        System.out.println("Väljumiseks vali: " + Menüü.MENÜÜST_VÄLJA.ordinal());


        Scanner valik = new Scanner(System.in);


        loop: while (true) {
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
                case MENÜÜST_VÄLJA -> {
                    break loop;
                }

            }
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

        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Auto uusAuto = new Auto(loomiseKuupäev, vinTähis, mark, mudel, klient, asukoht, töödeNimekiri);

        tabel.lisaAuto(uusAuto);

        System.out.println("Uus auto edukalt sisestatud!");

    }

    static void kustutaAutoMenüü() {
        System.out.print("Sisesta auto rea nr: ");
        Scanner sc = new Scanner(System.in);
        int reaNr = sc.nextInt();
        if (tabel.kustutaAuto(reaNr)) {
            System.out.println("Auto realt nr " + reaNr + " kustutatud!");
        }
        else {
            System.out.println("Auto eemaldamine ebaõnnestus. Kontrolli rea numberit!");
        }

    }


    static void prindiTabelMenüü() {
        System.out.println(tabel.prindiTabel());
    }
}

enum Menüü {
    LISA_AUTO, PRINDI_TABEL, KUSTUTA_AUTO, MENÜÜST_VÄLJA
}