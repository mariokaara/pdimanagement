import java.time.LocalDate;

public class Auto {

    private LocalDate kuupäev;
    private String vin;
    private String mark;
    private String mudel;
    private String klient;
    private String asukoht;
    private String töödeNimekiri;

    public Auto(LocalDate kuupäev, String vin, String mark, String mudel, String klient, String asukoht, String töödeNimekiri) {
        this.kuupäev = kuupäev;
        this.vin = vin;
        this.mark = mark;
        this.mudel = mudel;
        this.klient = klient;
        this.asukoht = asukoht;
        this.töödeNimekiri = töödeNimekiri;
    }

    public LocalDate getKuupäev() {
        return kuupäev;
    }

    public String getVin() {
        return vin;
    }

    public String getMark() {
        return mark;
    }

    public String getMudel() {
        return mudel;
    }

    public String getKlient() {
        return klient;
    }

    public String getAsukoht() {
        return asukoht;
    }

    public String getTöödeNimekiri() {
        return töödeNimekiri;
    }

    public void setKuupäev(LocalDate kuupäev) {
        this.kuupäev = kuupäev;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setMudel(String mudel) {
        this.mudel = mudel;
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }

    public void setAsukoht(String asukoht) {
        this.asukoht = asukoht;
    }

    public void setTöödeNimekiri(String töödeNimekiri) {
        this.töödeNimekiri = töödeNimekiri;
    }
}
