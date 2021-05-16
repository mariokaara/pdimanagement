import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.InputStream;
import java.time.LocalDate;

public class AutoVorm extends VBox {

    static final EventType<Event> AUTO_MUUTMINE = new EventType<>("AUTO_MUUTMINE");
    static final EventType<Event> AUTO_LISAMINE = new EventType<>("AUTO_LISAMINE");

    public AutoVorm(ObservableList<Auto> vaadeldavadAutod, ObjectProperty<Auto> aktiivneAuto) {

        super(10);

        this.setAlignment(Pos.TOP_CENTER);

        DatePicker kalender = new DatePicker();
        kalender.setValue(LocalDate.now());
        kalender.setFocusTraversable(true);

        TextField textField2 = new TextField();
        textField2.setPromptText("Sisesta VIN tähis: ");
        textField2.setFocusTraversable(true);

        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll("Renault", "Dacia");
        comboBox1.setPromptText("Sisesta auto mark: ");
        comboBox1.setFocusTraversable(true);

        TextField textField4 = new TextField();
        textField4.setPromptText("Sisesta auto mudel: ");
        textField4.setFocusTraversable(true);

        TextField textField5 = new TextField();
        textField5.setPromptText("Sisesta auto värvus: ");
        textField5.setFocusTraversable(true);

        TextField textField6 = new TextField();
        textField6.setPromptText("Sisesta kliendi nimi: ");
        textField6.setFocusTraversable(true);

        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll("Tartu", "Laagri", "Narva", "Kuressaare");
        comboBox2.setPromptText("Sisesta auto asukoht: ");
        comboBox2.setFocusTraversable(true);

        TextField textField7 = new TextField();
        textField7.setPromptText("Sisesta tööd: ");
        textField7.setFocusTraversable(true);

        Button lisaAuto = new Button("LISA");

        Button muudaAuto = new Button("MUUDA");

        Button kustutaAuto;

        Button salvesta = new Button("SALVESTA");


        try (InputStream input = getClass().getResourceAsStream("pilt_kustuta.png")) {
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setPreserveRatio(true);
            kustutaAuto = new Button("KUSTUTA", imageView);
        } catch (Exception e) {
            kustutaAuto = new Button("KUSTUTA");
        }


        aktiivneAuto.addListener(new ChangeListener<Auto>() {
            @Override
            public void changed(ObservableValue<? extends Auto> observable, Auto oldValue, Auto newValue) {
                kalender.setValue(newValue.getKuupäev());
                textField2.setText(newValue.getVin());
                comboBox1.setValue(newValue.getMark());
                textField4.setText(newValue.getMudel());
                textField5.setText(newValue.getVärvus());
                textField6.setText(newValue.getKlient());
                comboBox2.setValue(newValue.getAsukoht());
                textField7.setText(newValue.getTöödeNimekiri());
            }
        });


        lisaAuto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                LocalDate kuupäev = kalender.getValue();
                String vin = textField2.getText();
                String mark = comboBox1.getValue();
                String mudel = textField4.getText();
                String värvus = textField5.getText();
                String klient = textField6.getText();
                String asukoht = comboBox2.getValue();
                String töödeNimekiri = textField7.getText();

                Auto auto = new Auto(kuupäev, vin, mark, mudel, värvus, klient, asukoht, töödeNimekiri);

                vaadeldavadAutod.add(auto);
                fireEvent(new Event(AUTO_LISAMINE));

                textField2.clear();
                textField4.clear();
                textField5.clear();
                textField7.clear();
            }
        });
        muudaAuto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate kuupäev = kalender.getValue();
                String vin = textField2.getText();
                String mark = comboBox1.getValue();
                String mudel = textField4.getText();
                String värvus = textField5.getText();
                String klient = textField6.getText();
                String asukoht = comboBox2.getValue();
                String töödeNimekiri = textField7.getText();

                Auto auto = aktiivneAuto.get();

                auto.setKuupäev(kuupäev);
                auto.setVin(vin);
                auto.setMark(mark);
                auto.setMudel(mudel);
                auto.setVärvus(värvus);
                auto.setKlient(klient);
                auto.setAsukoht(asukoht);
                auto.setTöödeNimekiri(töödeNimekiri);
                aktiivneAuto.set(auto);
                fireEvent(new Event(AUTO_MUUTMINE));

                textField2.clear();
                textField4.clear();
                textField5.clear();
                textField6.clear();
                textField7.clear();
            }
        });

        kustutaAuto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vaadeldavadAutod.remove(aktiivneAuto.get());
            }
        });
        salvesta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FailiTabel failiTabel = new FailiTabel("andmebaas.txt");
                failiTabel.lisaAutod(vaadeldavadAutod);
            }
        });


        this.getChildren().addAll(kalender, textField2, comboBox1, textField4, textField5, textField6, comboBox2, textField7, lisaAuto, muudaAuto, kustutaAuto, salvesta);

        this.getChildren().forEach(x -> {
            VBox.setMargin(x, new Insets(0, 10, 0, 10));
        });

        Font font = Font.font("Roboto", FontWeight.BOLD, 14);
        lisaAuto.setFont(font);
        muudaAuto.setFont(font);
        kustutaAuto.setFont(font);
        salvesta.setFont(font);


    }

}
