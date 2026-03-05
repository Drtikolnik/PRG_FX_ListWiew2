package com.example.prg_fx_listwiew2;

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
    private ListView<Ukol> ukolListView;
    public ObservableList<Ukol> ukolObservableList = FXCollections.observableArrayList();


    @FXML
    protected void onPridat() {
        Ukol ukol = new Ukol(textFieldNazevUkolu.getText(), ((RadioButton) predmet.getSelectedToggle()).getText(), ((RadioButton) priorita.getSelectedToggle()).getText(), splneno.isSelected() );
        ukolObservableList.add(ukol);
        ukolListView.setItems(ukolObservableList);
        predmet.getSelectedToggle().setSelected(false);
        priorita.getSelectedToggle().setSelected(false);
        splneno.setSelected(false);

    }

    @FXML
    protected void onVybrat() {
        Ukol vybranyUkol = ukolListView.getSelectionModel().getSelectedItem();

        String stav = vybranyUkol.isSplneno() ? "[SPLNĚNO]" : "[NESPLNĚNO]";
        labelDetail.setText("Název: " +vybranyUkol.getJmeno()+ " Předmět: " +vybranyUkol.getPredmet()+ " Priorita: " +vybranyUkol.getPriorita()+ " Stav: " +stav );
    }

}
