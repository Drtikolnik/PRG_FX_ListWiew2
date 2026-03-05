module com.example.prg_fx_listwiew2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prg_fx_listwiew2 to javafx.fxml;
    exports com.example.prg_fx_listwiew2;
}