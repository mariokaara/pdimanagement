import java.util.ArrayList;

public class Tabel {
    ArrayList<Auto> autoTabel = new ArrayList<>();

    public void lisAuto(Auto auto) {
        autoTabel.add(auto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nimi | \n"); //tee tabeli päis
        for (Auto auto: autoTabel) {
            sb.append(auto.getMark());
            sb.append("|");
            sb.append(auto.getMudel());
            sb.append("\n");
        }
        //for loopiga käi läbi autoTabel ja sb.append(
        return sb.toString();
    }
}
