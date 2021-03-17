import java.util.ArrayList;

public class MäluTabel implements  Tabel{
    ArrayList<Auto> autoTabel = new ArrayList<>();

    public void lisaAuto(Auto auto) {
        autoTabel.add(auto);
    }

    @Override
    public void kustutaAuto(int autoId) {

    }

    @Override
    public String prindiTabel() {
        return null;
    }

    @Override
    public String toString() {

        int kliendiVäljaPikkus = kliendiVäljaPikkus();
        String kliendiPäis = "Klient";
        kliendiPäis = String.format("%1$-" + kliendiVäljaPikkus + "s", kliendiPäis);

        StringBuilder sb = new StringBuilder();
        sb.append("Kuupäev   |       VIN       | Mark  |    Mudel    | Asukoht  |" + kliendiPäis + "|\n");
        for (Auto auto: autoTabel) {
            sb.append(auto.getKuupäev());
            sb.append("|");
            sb.append(auto.getVin());
            sb.append("|");
            sb.append(String.format("%1$-7s", auto.getMark()));
            sb.append("|");
            sb.append(auto.getMudel());
            sb.append("|");
            sb.append(String.format("%1$-10s", auto.getAsukoht()));
            sb.append("|");
            sb.append(String.format("%1$-" + kliendiVäljaPikkus +"s", auto.getKlient()));
            sb.append("|");
            sb.append("\n");
        }
        return sb.toString();
    }

    private int kliendiVäljaPikkus() {
        int pikkus = 0;

        for (Auto i: autoTabel) {
            if (i.getKlient().length() > pikkus) {
                pikkus = i.getKlient().length();
            }
        }

        return pikkus;
    }
}
