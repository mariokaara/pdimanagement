public interface Tabel {

    // Liides Tabel annab ette nõutud käitumise klassidele, mis seda implementeerivad
    // Autode lisamine, autode kustutamine ja tabeli printimine


    void lisaAuto(Auto auto);

    boolean kustutaAuto(int reaNr);

    String prindiTabel();
}
