import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableObjectValue;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class AutoTabel extends TableView<Auto> {

    public AutoTabel(ObservableList<Auto> autod, WritableObjectValue<Auto> aktiivneAuto) {

        this.setOnMouseClicked(x -> {
            Auto valitudAuto = getSelectionModel().getSelectedItem();
            aktiivneAuto.set(valitudAuto);
        });

        TableColumn kuupäev = new TableColumn<Tabel, String>("Kuupäev");
        kuupäev.setMaxWidth(75);
        kuupäev.setMinWidth(75);
        kuupäev.setCellValueFactory(new PropertyValueFactory<Tabel, String>("kuupäev"));

        TableColumn vin = new TableColumn<Tabel, String>("VIN");
        vin.setMaxWidth(130);
        vin.setMinWidth(130);
        vin.setCellValueFactory(new PropertyValueFactory<Tabel, String>("vin"));

        TableColumn mark = new TableColumn<Tabel, String>("Mark");
        mark.setMaxWidth(150);
        mark.setMinWidth(100);
        mark.setCellValueFactory(new PropertyValueFactory<Tabel, String>("mark"));

        TableColumn mudel = new TableColumn<Tabel, String>("Mudel");
        mudel.setMaxWidth(150);
        mudel.setMinWidth(100);
        mudel.setCellValueFactory(new PropertyValueFactory<Tabel, String>("mudel"));

        TableColumn klient = new TableColumn<Tabel, String>("Klient");
        klient.setMaxWidth(150);
        klient.setMinWidth(100);
        klient.setCellValueFactory(new PropertyValueFactory<Tabel, String>("klient"));

        TableColumn asukoht = new TableColumn<Tabel, String>("Asukoht");
        asukoht.setMaxWidth(150);
        asukoht.setMinWidth(60);
        asukoht.setCellValueFactory(new PropertyValueFactory<Tabel, String>("asukoht"));

        TableColumn töödeNimekiri= new TableColumn<Tabel, String>("Tööde nimekiri");
        asukoht.setMaxWidth(900);
        asukoht.setMinWidth(60);
        töödeNimekiri.setCellValueFactory(new PropertyValueFactory<Tabel, ArrayList>("töödeNimekiri"));

        getColumns().addAll(kuupäev, vin, mark, mudel, klient,asukoht, töödeNimekiri);

        setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // lisab autod tabelisse kasutades ObservableListi (jälgib pidevalt listi muudatusi)
        setItems(autod);

    }

}
