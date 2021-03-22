import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FailiTabel implements Tabel {

    private Path fail;

    public FailiTabel(String failiNimi) {
        try {
            this.fail = Path.of(failiNimi);
            if (!Files.exists(fail)) {
                Files.createFile(Path.of(failiNimi));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lisaAuto(Auto auto) {
        //TODO: Lisa kõik auto väljad
        String autoRida = auto.getKuupäev() + "," + auto.getVin() + "\n";
        try {
            Files.writeString(fail, autoRida, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void kustutaAuto(int autoId) {
        try {
            List<String> read = Files.readAllLines(fail);
            read.remove(autoId - 1);
            Files.write(fail, read, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
