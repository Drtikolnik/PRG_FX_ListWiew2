package com.example.prg_fx_listwiew2;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label labelDetail;
    @FXML
    private TextField textFieldNazevUkolu;

    @FXML
    private ToggleGroup predmet;
    @FXML private RadioButton predmet1;@FXML private RadioButton predmet2;@FXML private RadioButton predmet3;@FXML private RadioButton predmet4;@FXML private RadioButton predmet5;

    @FXML
    private ToggleGroup priorita;
    @FXML private RadioButton priorita1;@FXML private RadioButton priorita2;@FXML private RadioButton priorita3;

    @FXML
    private CheckBox splneno;

    @FXML
    private Button buttonPridat;
    @FXML
    private Button buttonVybrat;
    @FXML
    private Button buttonUpravit;
    @FXML
    private Button buttonSmazat;



    @FXML
    private ListView<Ukol> ukolListView;
    public ObservableList<Ukol> ukolObservableList = FXCollections.observableArrayList();


    @FXML
    protected void onPridat() {
        if(textFieldNazevUkolu.getText()!=null && !textFieldNazevUkolu.getText().isEmpty() &&  predmet.getSelectedToggle()!=null && priorita.getSelectedToggle()!=null) {
            Ukol ukol = new Ukol(textFieldNazevUkolu.getText(), ((RadioButton) predmet.getSelectedToggle()).getText(), ((RadioButton) priorita.getSelectedToggle()).getText(), splneno.isSelected() );
            ukolObservableList.add(ukol);
            ukolListView.setItems(ukolObservableList);
            textFieldNazevUkolu.clear();
            predmet.getSelectedToggle().setSelected(false);
            priorita.getSelectedToggle().setSelected(false);
            splneno.setSelected(false);
        }else{
            labelDetail.setText("NEJSOU ZADANÉ POTŘEBNÉ INFORMACE");
        }



    }

    @FXML
    protected void onVybrat() {
        Ukol vybranyUkol = ukolListView.getSelectionModel().getSelectedItem();

        if (vybranyUkol != null) {
            textFieldNazevUkolu.setText(vybranyUkol.getJmeno());
            switch (vybranyUkol.getPredmet()) {
                case "Matematika" -> predmet1.setSelected(true);
                case "Český jazyk" -> predmet2.setSelected(true);
                case "Literatura" -> predmet3.setSelected(true);
                case "Programování" -> predmet4.setSelected(true);
                case "Uživatelské rozhraní" -> predmet5.setSelected(true);
            }
            switch (vybranyUkol.getPriorita()) {
                case "Nízká" -> priorita1.setSelected(true);
                case "Střední" -> priorita2.setSelected(true);
                case "Vysoká" -> priorita3.setSelected(true);
            }
            if(splneno.isSelected()) {
                splneno.setSelected(true);
            }

            String stav = vybranyUkol.isSplneno() ? "[SPLNĚNO]" : "[NESPLNĚNO]";
            labelDetail.setText("Název: " +vybranyUkol.getJmeno()+ ", Předmět: " +vybranyUkol.getPredmet()+ ", Priorita: " +vybranyUkol.getPriorita()+ ", Stav: " +stav );
        }else{
            labelDetail.setText("NENÍ VYBRANÝ ŽÁDNÝ ÚKOL");
        }

    }

    @FXML
    protected void onUpravit() {
        Ukol vybranyUkol = ukolListView.getSelectionModel().getSelectedItem();

        if(textFieldNazevUkolu.getText()!=null && !textFieldNazevUkolu.getText().isEmpty() &&  predmet.getSelectedToggle()!=null && priorita.getSelectedToggle()!=null) {
            vybranyUkol.setJmeno(textFieldNazevUkolu.getText());
            vybranyUkol.setPredmet(((RadioButton) predmet.getSelectedToggle()).getText());
            vybranyUkol.setPriorita(((RadioButton) priorita.getSelectedToggle()).getText());
            vybranyUkol.setSplneno(splneno.isSelected());
            ukolListView.refresh();
            textFieldNazevUkolu.clear();
            predmet.getSelectedToggle().setSelected(false);
            priorita.getSelectedToggle().setSelected(false);
            splneno.setSelected(false);
        }else{
            labelDetail.setText("NEJSOU ZADANÉ POTŘEBNÉ INFORMACE");
        }


    }

    @FXML
    protected void onSmazat() {
        if(ukolListView.getSelectionModel().getSelectedItem()!=null){
            ukolObservableList.remove(ukolListView.getSelectionModel().getSelectedItem()) ;
            ukolListView.refresh();
        }else{
            labelDetail.setText("NENÍ VYBRANÝ ŽÁDNÝ ÚKOL");
        }

    }



    @FXML
    protected void onButtonFiltrVse() {
        ukolListView.setItems(ukolObservableList);
    }

    @FXML
    protected void onButtonFiltrSplneno() {
        ObservableList<Ukol> ukolSplnenoObservableList = FXCollections.observableArrayList();
        for (Ukol ukol : ukolObservableList) {
            if (ukol.isSplneno()) {
                ukolSplnenoObservableList.add(ukol);
            }
        }
        ukolListView.setItems(ukolSplnenoObservableList);
    }

    @FXML
    protected void onButtonFiltrNesplneno() {
        ObservableList<Ukol> ukolNesplnenoObservableList = FXCollections.observableArrayList();
        for (Ukol ukol : ukolObservableList) {
            if (!ukol.isSplneno()) {
                ukolNesplnenoObservableList.add(ukol);
            }
        }
        ukolListView.setItems(ukolNesplnenoObservableList);
    }

    @FXML
    public void handleShowNapoveda(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NÁPOVĚDA");
        alert.setHeaderText("Zde je nápověda k programu:");
        alert.setContentText("Soubor --> Zavřít\n Zobrazit(filtr) ----> Vše, Pouze splněné, pouze nesplněné.  \n musíte zadat všechny údaje abyste mohli pridat polozku do ukolnicku ");
        alert.showAndWait();
        if(alert.getResult()==ButtonType.OK){
            Platform.exit();
        }
    }


    public void handleShowZavritProgram(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ZAVŘENÍ PROGRAMU");
        alert.setHeaderText("Chcete opravdu zavřít program?");
        alert.setContentText("Zavření programu vymaže všechna uložená data");
        alert.showAndWait();
        if(alert.getResult()==ButtonType.OK){
            Platform.exit();
        }
    }






}