package com.example.projetopoo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProcessoController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}