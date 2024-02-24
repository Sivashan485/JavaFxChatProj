package com.example.javafxchatproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;

public class loginViewControler {

    String username = "ASDF";
    String pwd = "ASDF";
    @FXML
    private Label welcomeText;

    @FXML
    private TextField TfUsername;

    @FXML
    private PasswordField PfPassword;



    @FXML
    public void onClickLoginView(ActionEvent actionEvent) throws IOException {
        if(checkLogin()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home-view.fxml"));
            Parent root = loader.load();

            homeView.executeHomeView(actionEvent);


        }else{
            createFailedLoginMessage();
        }
    }


    private boolean checkLogin(){
        return (TfUsername.getText().equals(username) && PfPassword.getText().equals(pwd));
    }

    private void createFailedLoginMessage(){
        Alert loginFailedMessage = new Alert(Alert.AlertType.WARNING);
        loginFailedMessage.setTitle("JAVAFXCHAT - ERROR");
        loginFailedMessage.setHeaderText("SOMETHING IS WRONG WITH THE LOGIN PROCEDURE");
        loginFailedMessage.setContentText("Login failed, pls try again!!!");
        loginFailedMessage.show();
    }


}