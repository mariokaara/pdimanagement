import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableObjectValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class AutoVorm extends VBox {

    public AutoVorm(ObservableList<Auto> vaadeldavadAutod, ObjectProperty<Auto> aktiivneAuto) {

        super(10);
        this.setAlignment(Pos.TOP_CENTER);
        TextField textField1 = new TextField();
        textField1.setPromptText("Sisesta kuupäev: ");
        textField1.setFocusTraversable(false);
        TextField textField2 = new TextField();
        textField2.setPromptText("Sisesta VIN tähis: ");
        textField2.setFocusTraversable(false);
        TextField textField3 = new TextField();
        textField3.setPromptText("Sisesta auto mark: ");
        textField3.setFocusTraversable(false);
        TextField textField4 = new TextField();
        textField4.setPromptText("Sisesta auto mudel: ");
        textField4.setFocusTraversable(false);
        TextField textField5 = new TextField();
        textField5.setPromptText("Sisesta kliendi nimi: ");
        textField5.setFocusTraversable(false);
        TextField textField6 = new TextField();
        textField6.setPromptText("Sisesta auto asukoht: ");
        textField6.setFocusTraversable(false);
        TextField textField7 = new TextField();
        textField7.setPromptText("Sisesta tööd: ");
        textField7.setFocusTraversable(false);
        Button lisaAuto = new Button("Lisa auto");

        aktiivneAuto.addListener(new ChangeListener<Auto>() {
            @Override
            public void changed(ObservableValue<? extends Auto> observable, Auto oldValue, Auto newValue) {
                textField1.setText(newValue.getKuupäev().toString());
                textField2.setText(newValue.getVin());
                textField3.setText(newValue.getMark());
                textField4.setText(newValue.getMudel());
                textField5.setText(newValue.getKlient());
                textField6.setText(newValue.getAsukoht());
                textField7.setText(newValue.getTöödeNimekiri());
            }
        });



        lisaAuto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String kuupäev = textField1.getText();
                String vin = textField2.getText();
                String mark = textField3.getText();
                String mudel = textField4.getText();
                String klient = textField5.getText();
                String asukoht = textField6.getText();
                String töödeNimekiri = textField7.getText();

                Auto auto = new Auto(LocalDate.parse(kuupäev), vin, mark, mudel, klient, asukoht, töödeNimekiri);
                vaadeldavadAutod.add(auto);

                textField1.clear();
                textField2.clear();
                textField3.clear();
                textField4.clear();
                textField5.clear();
                textField6.clear();
                textField7.clear();
            }
        });


        this.getChildren().addAll(textField1, textField2, textField3, textField4, textField5, textField6, textField7, lisaAuto);

        this.getChildren().forEach(x -> {
            VBox.setMargin(x, new Insets(0, 10, 0, 10));
        });
    }

}
