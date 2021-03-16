import java.time.LocalDate;
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

        int id;


        // id lisatakse faili ja vaadatakse sealt viimast id-d ja lisatakse +1

        LocalDate loomiseKuupäev = LocalDate.now();

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
        String klient = klnt.nextLine();

        Scanner ak = new Scanner(System.in);
        System.out.println("Sisesta auto asukoht: ");
        String asukoht = ak.nextLine();

        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Auto uusAuto = new Auto(id, loomiseKuupäev, vinTähis, mark, mudel, klient, asukoht, töödeNimekiri);

        tabel.lisaAuto(uusAuto);

    }

    static void kustutaAuto() throws Exception {
        java.io.File fail = new java.io.File("c:/temp/tabel.txt");
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            ArrayList<String> list1 = new ArrayList<>();
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                list1.add(rida);


            }



        }


    }
    static void prindiAuto() {
        System.out.println("prindi");
    }
}
enum Menüü {
    LISA_AUTO, PRINDI_TABEL, KUSTUTA_AUTO
}