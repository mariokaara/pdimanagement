import java.util.ArrayList;

public class Tabel {
    ArrayList<Auto> autoTabel = new ArrayList<>();

    public void lisaAuto(Auto auto) {
        autoTabel.add(auto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kuupäev | VIN | Mark | Mudel | Asukoht | Klient \n");
        for (Auto auto: autoTabel) {
            sb.append(auto.getKuupäev());
            sb.append("|");
            sb.append(auto.getVin());
            sb.append("|");
            sb.append(auto.getMark());
            sb.append("|");
            sb.append(auto.getMudel());
            sb.append("|");
            sb.append(auto.getAsukoht());
            sb.append("|");
            sb.append(auto.getKlient());
            sb.append("|");
            sb.append("\n");
        }
        return sb.toString();
    }
}
