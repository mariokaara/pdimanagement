import java.time.LocalDate;
import java.util.ArrayList;

public class FailiTabelTest {

    public static void main(String... args){
        FailiTabel failiTabel = new FailiTabel("test.txt");
        System.out.println(failiTabel.prindiTabel());
        failiTabel.lisaAuto(new Auto(LocalDate.now(), "VIN","Mark","Mudel","","", new ArrayList()));
        System.out.println(failiTabel.prindiTabel());
        failiTabel.kustutaAuto(1);
        System.out.println(failiTabel.prindiTabel());
    }
}
