import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FailiTabel implements Tabel {

    // FailiTabeli klassi kasutatakse sõidukite andmete lisamiseks txt formaadis faili, et
    // sõidukite seis oleks pikemaajaliselt kättesaadav. MäluTabelit oli vaja pigem ajutiselt, et
    // kasutajal oleks võimalik programmi tööd testida (FailiTabeli funktsioneerimine oli natuke
    // ajamahukam ja esialgu ei olnud kindlust kas see mahub projekti skoopi (rühmatöö 1. osa)

    private Path fail;

    //kui faili ei eksisteeri, siis luuakse fail
    public FailiTabel(String failiNimi) {
        try {
            this.fail = Path.of(failiNimi);
            if (!Files.exists(fail)) {
                Files.createFile(Path.of(failiNimi));
            }
            // võimaliku probleemi korral "püütakse" siin erind kinni ja logitakse. Programm saab tänu sellele jätkuda.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // lisatakse auto isend ühe reana txt faili (lisatakse lõppu)
    @Override
    public void lisaAuto(Auto auto) {
        String autoRida = auto.getKuupäev() + "," + auto.getVin() + "," + auto.getMark() + "," + auto.getMudel() + "," + auto.getKlient() + "," + auto.getAsukoht() + "," + auto.getTöödeNimekiri() + "\n";
        try {
            // kirjutatakse faili lõppu
            Files.writeString(fail, autoRida, StandardOpenOption.APPEND);
            // võimaliku probleemi korral "püütakse" siin erind kinni ja logitakse. Programm saab tänu sellele jätkuda.
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void lisaAutod(List<Auto> list) {
        ArrayList<String> uusList = new ArrayList<>();
        try {
            for (Auto i : list) {
                String autoRida = i.getKuupäev() + "," + i.getVin() + "," + i.getMark() + "," + i.getMudel() + "," + i.getVärvus() + "," + i.getKlient() + "," + i.getAsukoht() + "," + i.getTöödeNimekiri();
                uusList.add(autoRida);
            }
            Files.write(fail, uusList, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // loetakse failist sisse kõik read ning kustutatakse isend realt, mille järjekorranumbri annab kasutaja (reaNr)
    @Override
    public boolean kustutaAuto(int reaNr) {
        try {
            List<String> read = Files.readAllLines(fail);
            if (reaNr > 0 && reaNr <= read.size()) {
                read.remove(reaNr - 1);
                Files.write(fail, read, StandardOpenOption.TRUNCATE_EXISTING);
                return true;
            } else {
                return false;
            }
            // võimaliku probleemi korral "püütakse" siin erind kinni ja logitakse. Programm saab tänu sellele jätkuda.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Kõik faili read lisatakse uude StringBuilder isendisse ja prinditakse ükshaaval välja
    @Override
    public String prindiTabel() {
        try {
            List<String> read = Files.readAllLines(fail);
            StringBuilder uuedRead = new StringBuilder();
            int i = 1;
            for (String rida : read) {
                uuedRead.append(i + "," + rida);
                uuedRead.append("\n");
                i++;
            }
            return uuedRead.toString();
            // võimaliku probleemi korral "püütakse" siin erind kinni ja logitakse. Programm saab tänu sellele jätkuda.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Auto> autodeList() {
        try {
            List<String> read = Files.readAllLines(fail);
            ArrayList<Auto> autodeList = new ArrayList<>();
            for (String rida : read) {
                if (rida.isEmpty()) {
                    continue;
                }
                int i = 0;
                String[] massiiv = rida.split(",", -1);
                LocalDate kuupäev = LocalDate.parse(massiiv[i]);
                String vin = massiiv[++i];
                String mark = massiiv[++i];
                String mudel = massiiv[++i];
                String värvus = massiiv[++i];
                String klient = massiiv[++i];
                String asukoht = massiiv[++i];
                String töödeNimekiri = massiiv[++i];
                Auto auto = new Auto(kuupäev, vin, mark, mudel, värvus, klient, asukoht, töödeNimekiri);
                autodeList.add(auto);
            }
            return autodeList;
            // võimaliku probleemi korral "püütakse" siin erind kinni ja logitakse. Programm saab tänu sellele jätkuda.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
