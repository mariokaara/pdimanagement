public class Töö {
    String tööNimi;
    boolean tehtud;
    String lisainfo;

    public Töö(String tööNimi, boolean tehtud, String lisainfo) {
        this.tööNimi = tööNimi;
        this.tehtud = tehtud;
        this.lisainfo = lisainfo;
    }

    public String getTööNimi() {
        return tööNimi;
    }

    public void setTööNimi(String tööNimi) {
        this.tööNimi = tööNimi;
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
