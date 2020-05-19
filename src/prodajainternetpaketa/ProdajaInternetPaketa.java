/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodajainternetpaketa;

import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jusuf
 */
public class ProdajaInternetPaketa extends Application {
    
    Label infoBrzina;
    Label infoProtok;
    Label infoTrajanje;
    Label infoKorisnik;
    TextField imeKorisnikaFld;
    TextField prezimeKorisnikaFld;
    TextField adresaKorisnikaFld;
    TextField IDbrisanjeFld;
    VBox vBox;
    ToggleGroup brzine;
    ToggleGroup protoci;
    ToggleGroup godine;
    String stringID = "0";
    int ID;
    TableView tableView;
    List<Paket> paketi = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Prodaja internet-paketa");
        vBox = new VBox();
        vBox.setStyle("-fx-padding: 10 20 10 20;");
        
        infoBrzina = new Label();
        infoProtok = new Label();
        infoTrajanje = new Label();
        infoKorisnik = new Label();
        
        tableView = new TableView();
        
        TableColumn<String, Paket> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("IDprodaje"));
        
        TableColumn<String, Paket> column2 = new TableColumn<>("Ime");
        column2.setCellValueFactory(new PropertyValueFactory<>("imeKorisnika"));
        
        TableColumn<String, Paket> column3 = new TableColumn<>("Prezime");
        column3.setCellValueFactory(new PropertyValueFactory<>("prezimeKorisnika"));
        
        TableColumn<String, Paket> column4 = new TableColumn<>("Adresa");
        column4.setCellValueFactory(new PropertyValueFactory<>("adresaKorisnika"));
        
        TableColumn<String, Paket> column5 = new TableColumn<>("Brzina");
        column5.setCellValueFactory(new PropertyValueFactory<>("brzina"));
        
        TableColumn<String, Paket> column6 = new TableColumn<>("Protok");
        column6.setCellValueFactory(new PropertyValueFactory<>("protok"));
        
        TableColumn<String, Paket> column7 = new TableColumn<>("Ugovor");
        column7.setCellValueFactory(new PropertyValueFactory<>("trajanjeUgovora"));
        
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        
        tableView.setPlaceholder(new Label("Još uvijek nema registrovanih kupovina!"));
        
        tableView.setStyle("-fx-alignment:  baseline-center;");
        column1.setStyle("-fx-alignment:  baseline-center;");
        column1.setMinWidth(38.0);
        column1.setPrefWidth(38.0);
        column1.setMaxWidth(38.0);
        
        column2.setStyle("-fx-alignment:  baseline-center;");
        column2.setMinWidth(80.0);
        column2.setPrefWidth(80.0);
        column2.setMaxWidth(80.0);
        
        column3.setStyle("-fx-alignment:  baseline-center;");
        column3.setMinWidth(100.0);
        column3.setPrefWidth(100.0);
        column3.setMaxWidth(100.0);
        
        column4.setStyle("-fx-alignment:  baseline-center;");
        column4.setMinWidth(150.0);
        column4.setPrefWidth(150.0);
        column4.setMaxWidth(150.0);
        
        column5.setStyle("-fx-alignment:  baseline-center;");
        column5.setMinWidth(70.0);
        column5.setPrefWidth(70.0);
        column5.setMaxWidth(70.0);
        
        column6.setStyle("-fx-alignment:  baseline-center;");
        column6.setMinWidth(70.0);
        column6.setPrefWidth(70.0);
        column6.setMaxWidth(70.0);
        
        column7.setStyle("-fx-alignment:  baseline-center;");
        column7.setMinWidth(90.0);
        column7.setPrefWidth(90.0);
        column7.setMaxWidth(90.0);
        
        Button registrujKupovinu = new Button();
        registrujKupovinu.setText("Registruj kupovinu");
        vBox.setMargin(registrujKupovinu, new Insets(2,0,2,240));
        registrujKupovinu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Registracija kupovine");
                alert.setHeaderText(null);
                alert.setContentText("Kupovina paketa je registrovana!!!");
                alert.showAndWait();
                
                ID = Integer.parseInt(stringID);
                ID++;
                stringID = Integer.toString(ID);
                
                Paket paket = new Paket(infoBrzina.getText(), infoProtok.getText(), infoTrajanje.getText(), stringID, 
                    imeKorisnikaFld.getText(), prezimeKorisnikaFld.getText(), adresaKorisnikaFld.getText());
                tableView.getItems().add(paket);
                paketi.add(paket);
            }
        });
        
        Button ukloniKupovinu = new Button();
        ukloniKupovinu.setText("Obriši kupovinu");
        vBox.setMargin(ukloniKupovinu, new Insets(2,0,2,250));
        ukloniKupovinu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
            }
        });
        
        
        Label brzinaLbl = new Label("Odaberite brzinu internet paketa:");
        RadioButton brzina2 = new RadioButton("2 Mbit");
        RadioButton brzina5 = new RadioButton("5 Mbit");
        RadioButton brzina10 = new RadioButton("10 Mbit");
        RadioButton brzina20 = new RadioButton("20 Mbit");
        RadioButton brzina50 = new RadioButton("50 Mbit");
        RadioButton brzina100 = new RadioButton("100 Mbit");
        
        brzina2.setPrefWidth(80);
        brzina5.setPrefWidth(80);
        brzina10.setPrefWidth(80);
        brzina20.setPrefWidth(80);
        brzina50.setPrefWidth(80);
        brzina100.setPrefWidth(80);
        
        brzine = new ToggleGroup();
        brzine.getToggles().addAll(brzina2, brzina5, brzina10, brzina20, brzina50, brzina100);
        brzine.selectedToggleProperty().addListener((observable, oldValue, newValue) -> toggleBrzina(observable, oldValue, newValue));
        
        GridPane gridPaneBrzine = new GridPane();
        gridPaneBrzine.setVgap(10.0);
        gridPaneBrzine.setHgap(10.0);
        vBox.setMargin(gridPaneBrzine, new Insets(0,2,10,2));
        gridPaneBrzine.addRow(1, brzina2, brzina5, brzina10, brzina20, brzina50, brzina100);
        
        
        Label protokLbl = new Label("Odaberite protok internet paketa:");
        RadioButton protok1 = new RadioButton("1 GB");
        RadioButton protok5 = new RadioButton("5 GB");
        RadioButton protok10 = new RadioButton("10 GB");
        RadioButton protok100 = new RadioButton("100 GB");
        RadioButton protokFlat = new RadioButton("Flat");
        
        protok1.setPrefWidth(80);
        protok5.setPrefWidth(80);
        protok10.setPrefWidth(80);
        protok100.setPrefWidth(80);
        protokFlat.setPrefWidth(80);
        
        protoci = new ToggleGroup();
        protoci.getToggles().addAll(protok1, protok5, protok10, protok100, protokFlat);
        protoci.selectedToggleProperty().addListener((observable, oldValue, newValue) -> toggleProtok(observable, oldValue, newValue));
        
        GridPane gridPaneProtoci = new GridPane();
        gridPaneProtoci.setVgap(10.0);
        gridPaneProtoci.setHgap(10.0);
        vBox.setMargin(gridPaneProtoci, new Insets(0,2,10,2));
        gridPaneProtoci.addRow(1, protok1, protok5, protok10, protok100, protokFlat);
        
        
        Label trajanjeUgovoraLbl = new Label("Odaberite trajanje ugovora:");
        RadioButton godina1 = new RadioButton("1 godina");
        RadioButton godina2 = new RadioButton("2 godine");
        
        godina1.setPrefWidth(80);
        godina2.setPrefWidth(80);
        
        godine = new ToggleGroup();
        godine.getToggles().addAll(godina1, godina2);
        godine.selectedToggleProperty().addListener((observable, oldValue, newValue) -> toggleGodine(observable, oldValue, newValue));
        
        GridPane gridPaneGodine = new GridPane();
        gridPaneGodine.setVgap(10.0);
        gridPaneGodine.setHgap(10.0);
        vBox.setMargin(gridPaneGodine, new Insets(0,2,10,2));
        gridPaneGodine.addRow(1, godina1, godina2);
        
        
        Label imeKorisnikaLbl = new Label("Unesite Vaše ime:");
        imeKorisnikaFld = new TextField();
        vBox.setMargin(imeKorisnikaFld, new Insets(0,2,10,2));
        imeKorisnikaFld.setMinWidth(200.0);
        imeKorisnikaFld.setPrefWidth(200.0);
        imeKorisnikaFld.setMaxWidth(200.0);
        
        
        Label prezimeKorisnikaLbl = new Label("Unesite Vaše prezime:");
        prezimeKorisnikaFld = new TextField();
        vBox.setMargin(prezimeKorisnikaFld, new Insets(0,2,10,2));
        prezimeKorisnikaFld.setMinWidth(200.0);
        prezimeKorisnikaFld.setPrefWidth(200.0);
        prezimeKorisnikaFld.setMaxWidth(200.0);
        
        
        Label adresaKorisnikaLbl = new Label("Unesite Vašu adresu:");
        adresaKorisnikaFld = new TextField();
        vBox.setMargin(adresaKorisnikaFld, new Insets(0,2,10,2));
        adresaKorisnikaFld.setMinWidth(200.0);
        adresaKorisnikaFld.setPrefWidth(200.0);
        adresaKorisnikaFld.setMaxWidth(200.0);
        
        vBox.getChildren().addAll(
                brzinaLbl, gridPaneBrzine, 
                protokLbl, gridPaneProtoci, 
                trajanjeUgovoraLbl, gridPaneGodine, 
                imeKorisnikaLbl, imeKorisnikaFld, 
                prezimeKorisnikaLbl, prezimeKorisnikaFld, 
                adresaKorisnikaLbl, adresaKorisnikaFld, 
                registrujKupovinu, 
                tableView,
                ukloniKupovinu);
        
        Scene scene = new Scene(vBox, 640, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void toggleBrzina(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

        if (newValue != null) {
            ToggleButton toggleButton = (ToggleButton) newValue;
            infoBrzina.setText(toggleButton.getText());
        }
    }
    
    private void toggleProtok(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

        if (newValue != null) {
            ToggleButton toggleButton = (ToggleButton) newValue;
            infoProtok.setText(toggleButton.getText());
        }
    }
    
    private void toggleGodine(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

        if (newValue != null) {
            ToggleButton toggleButton = (ToggleButton) newValue;
            infoTrajanje.setText(toggleButton.getText());
        }
    }
    
}
