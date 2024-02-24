package com.example.javafxchatproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;

public class homeView {

    public static void executeHomeView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginView.class.getResource("home-view.fxml"));


        // Access the controller
        // Set items to the ListView in the controller



        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("JavaFXCHAT HOME");
        stage.setScene(scene);



        stage.show();

    }

}
