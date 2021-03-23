public interface Tabel {
    default void lisaAuto(Auto auto) {

    }

    default void lisaTöö(Töö töö) {

    }

    boolean kustutaAuto(int reaNr);
    String prindiTabel();
}
