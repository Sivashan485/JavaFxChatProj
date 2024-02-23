package com.example.javafxchatproj;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class loginViewControler {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFXChat!");
    }
}