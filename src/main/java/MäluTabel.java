import java.util.ArrayList;

public class MäluTabel implements Tabel {

    // MäluTabel on sõidukite salvestamiseks ja printimiseks konsoolist, kuid tabeli seis
    // piirdub IDE sulgemisega (mälu kustub). Küll aga on MäluTabelis salvestatud sõidukite
    // seisu väljaprint standardiseeritud ja visuaalselt hästi mõistetav (kasutatud on paddinguid
    // ning dünaamilisi väljapikkusi).

    ArrayList<Auto> autoTabel = new ArrayList<>();

    public void lisaAuto(Auto auto) {
        autoTabel.add(auto);
    }

    //
    @Override
    public boolean kustutaAuto(int reaNr) {
        if (reaNr > 0 && reaNr <= autoTabel.size()) {
            autoTabel.remove(reaNr - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String prindiTabel() {
        if (autoTabel.isEmpty()) {
            return "Tabel on tühi!";
        }
        int kliendiVäljaPikkus = kliendiVäljaPikkus();
        int mudeliVäljapikkus = mudeliVäljapikkus();
        String kliendiPäis = "Klient";
        String mudeliPäis = "Mudel";
        kliendiPäis = String.format("%1$-" + kliendiVäljaPikkus + "s", kliendiPäis);
        mudeliPäis = String.format("%1$-" + mudeliVäljapikkus + "s", mudeliPäis);

        StringBuilder sb = new StringBuilder();
        sb.append("|Nr |Kuupäev   |       VIN       | Mark  |" + mudeliPäis + "| Asukoht  |" + kliendiPäis + "|\n");

        int i = 1;

        for (Auto auto : autoTabel) {
            sb.append("|");
            sb.append(String.format("%1$-3s", i++));
            sb.append("|");
            sb.append(auto.getKuupäev());
            sb.append("|");
            sb.append(auto.getVin());
            sb.append("|");
            sb.append(String.format("%1$-7s", auto.getMark()));
            sb.append("|");
            sb.append(String.format("%1$-" + mudeliVäljapikkus + "s", auto.getMudel()));
            sb.append("|");
            sb.append(String.format("%1$-10s", auto.getAsukoht()));
            sb.append("|");
            sb.append(String.format("%1$-" + kliendiVäljaPikkus + "s", auto.getKlient()));
            sb.append("|");
            sb.append("\n");
        }
        return sb.toString();
    }

    private int kliendiVäljaPikkus() {
        int pikkus = 0;

        for (Auto i : autoTabel) {
            if (i.getKlient().length() > pikkus) {
                pikkus = i.getKlient().length();
            }
        }

        return pikkus;
    }

    private int mudeliVäljapikkus() {
        int pikkus = 0;

        for (Auto i : autoTabel) {
            if (i.getMudel().length() > pikkus) {
                pikkus = i.getMudel().length();
            }
        }

        return pikkus;
    }
}
