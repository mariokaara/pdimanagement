import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
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
        SimpleObjectProperty<Auto> aktiivneAuto = new SimpleObjectProperty<>();


        // Ülemine
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Label top = new Label("PDI Management v1.0");
        top.setFont(new Font("Roboto", 18));
        hBox.getChildren().add(top);
        root.setTop(hBox);


        // Vasak

        AutoVorm autoVorm = new AutoVorm(vaadeldavadAutod, aktiivneAuto);
        root.setLeft(autoVorm);


        // Keskmine
        //
        AutoTabel table = new AutoTabel(vaadeldavadAutod, aktiivneAuto);
        root.setCenter(table);

        // Parem
        //Button right = new Button("Right");
        //root.setRight(right);


        // Alumine
        Label silt = new Label("xxx");
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