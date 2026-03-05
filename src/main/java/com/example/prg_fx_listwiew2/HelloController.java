package com.example.prg_fx_listwiew2;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;
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
    protected void onPridat() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
