public class Töö {
    String nimi;
    boolean tehtud;
    String lisainfo;

    public Töö(String nimi, boolean tehtud, String lisainfo) {
        this.nimi = nimi;
        this.tehtud = tehtud;
        this.lisainfo = lisainfo;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public boolean isTehtud() {
        return tehtud;
    }

    public void setTehtud(boolean tehtud) {
        this.tehtud = tehtud;
    }

    public String getLisainfo() {
        return lisainfo;
    }

    public void setLisainfo(String lisainfo) {
        this.lisainfo = lisainfo;
    }
}
