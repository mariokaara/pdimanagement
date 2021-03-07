import java.time.LocalDate;
import java.util.ArrayList;

public class Auto {
    private LocalDate kuupäev;
    private String VIN;
    private Mark mark;
    private String mudel;
    private String klient;
    private Asukoht asukoht;
    private ArrayList töödeNimekiri;

    public Auto(LocalDate kuupäev, String VIN, Mark mark, String mudel, String klient, Asukoht asukoht, ArrayList töödeNimekiri) {
        this.kuupäev = kuupäev;
        this.VIN = VIN;
        this.mark = mark;
        this.mudel = mudel;
        this.klient = klient;
        this.asukoht = asukoht;
        this.töödeNimekiri = töödeNimekiri;
    }

    public LocalDate getKuupäev() {
        return kuupäev;
    }

    public String getVIN() {
        return VIN;
    }

    public Mark getMark() {
        return mark;
    }

    public String getMudel() {
        return mudel;
    }

    public String getKlient() {
        return klient;
    }

    public Asukoht getAsukoht() {
        return asukoht;
    }

    public ArrayList getTöödeNimekiri() {
        return töödeNimekiri;
    }
}
enum Mark {
    Renault, Dacia;
}
enum Asukoht {
    Tartu, Laagri, Kuressaare, Narva;
}
