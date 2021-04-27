import javafx.beans.value.WritableObjectValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Arrays;

public class AutoTabel extends TableView<Auto> {

    // Observable listi "autod# soovime tabelis kuvada ja aktiivneAuto on see isend, mis on vormis kuvatud
    public AutoTabel(ObservableList<Auto> autod, WritableObjectValue<Auto> aktiivneAuto) {

        this.setOnMouseClicked(x -> {
            //tabelil klikkimisel valitakse aktiivseks autoks isend millel klikiti
            Auto valitudAuto = getSelectionModel().getSelectedItem();
            aktiivneAuto.set(valitudAuto);
        });

        // luuakse ja vormindatakse tabeli veerud
        // setCellValuFactory:propertyValueFactory ülesandeks on peegeldust kasutades kutsuda välja vastava tabeli rea
        // auto isendi getter meetodit, mille nimi on sõnena ette antud

        TableColumn<Auto, String> kuupäev = new TableColumn<>("Kuupäev");
        kuupäev.setMaxWidth(75);
        kuupäev.setMinWidth(75);
        //siin kasutatakse getkuupäevFormaaditud, mis asub Auto klassis
        kuupäev.setCellValueFactory(new PropertyValueFactory<>("kuupäevFormaaditud"));

        TableColumn<Auto, String> vin = new TableColumn<>("VIN");
        vin.setMaxWidth(130);
        vin.setMinWidth(130);
        vin.setCellValueFactory(new PropertyValueFactory<>("vin"));

        TableColumn<Auto, String> mark = new TableColumn<>("Mark");
        mark.setMaxWidth(150);
        mark.setMinWidth(100);
        mark.setCellValueFactory(new PropertyValueFactory<>("mark"));

        TableColumn<Auto, String> mudel = new TableColumn<>("Mudel");
        mudel.setMaxWidth(150);
        mudel.setMinWidth(100);
        mudel.setCellValueFactory(new PropertyValueFactory<>("mudel"));

        TableColumn<Auto, String> värvus = new TableColumn<>("Värvus");
        värvus.setMaxWidth(150);
        värvus.setMinWidth(100);
        värvus.setCellValueFactory(new PropertyValueFactory<>("värvus"));

        TableColumn<Auto, String> klient = new TableColumn<>("Klient");
        klient.setMaxWidth(150);
        klient.setMinWidth(100);
        klient.setCellValueFactory(new PropertyValueFactory<>("klient"));

        TableColumn<Auto, String> asukoht = new TableColumn<>("Asukoht");
        asukoht.setMaxWidth(150);
        asukoht.setMinWidth(60);
        asukoht.setCellValueFactory(new PropertyValueFactory<>("asukoht"));

        TableColumn<Auto, String> töödeNimekiri = new TableColumn<>("Tööde nimekiri");
        asukoht.setMaxWidth(900);
        asukoht.setMinWidth(60);
        töödeNimekiri.setCellValueFactory(new PropertyValueFactory<>("töödeNimekiri"));

        getColumns().setAll(Arrays.asList(kuupäev, vin, mark, mudel, värvus, klient, asukoht, töödeNimekiri));

        setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // lisab autod tabelisse kasutades ObservableListi (jälgib pidevalt listi muudatusi)
        setItems(autod);

    }

}
