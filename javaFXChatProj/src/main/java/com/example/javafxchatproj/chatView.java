package com.example.javafxchatproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class chatView {

    public static void executeChatView(ActionEvent event,String chattingWith) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginView.class.getResource("chat-view.fxml"));

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("JavaFXCHAT CHAT WITH " + chattingWith);
        stage.setScene(scene);

        stage.show();
    }

}
