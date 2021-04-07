import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MainView {

    private Stage stage;
    private BorderPane root;
    private Scene scene;
    private Insets INSETS = new Insets(10, 5, 10, 5);
    private Tabel table;


    public MainView(Stage stage) {
        this.stage = stage;
        buildUI();
    }

    private void buildUI() {
        root = new BorderPane();
        List<Auto> autod = new ArrayList<>();
        ObservableList<Auto> vaadeldavadAutod = FXCollections.observableList(autod);

        // Ülemine
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Label top = new Label("PDI Management v1.0");
        top.setFont(new Font("Roboto", 18));
        hBox.getChildren().add(top);
        root.setTop(hBox);


        // Vasak

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.TOP_CENTER);
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
            }
        });


        vbox.getChildren().addAll(textField1, textField2, textField3, textField4, textField5, textField6, textField7, lisaAuto);
        root.setLeft(vbox);


        // Keskmine
        //
        AutoTabel table = new AutoTabel(vaadeldavadAutod);
        root.setCenter(table);

        // Parem
        //Button right = new Button("Right");
        //root.setRight(right);


        // Alumine
        Label silt = new Label("Made by Mario Käära");
        silt.setFont(new Font(10));
        silt.setAlignment(Pos.BOTTOM_CENTER);
        root.setBottom(silt);

        scene = new Scene(root);
        stage.setTitle("PDI Management v1.0");
        stage.setScene(scene);
        stage.setMinWidth(750);
        stage.setMinHeight(650);
        stage.show();
    }


}