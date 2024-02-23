package com.example.javafxchatproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginViewControler {

    String username = "ASDF";
    String pwd = "ASDF";
    @FXML
    private Label welcomeText;

    @FXML
    private TextField TfUsername;

    @FXML
    private PasswordField PfPassword;



    public void onClickLoginView(ActionEvent actionEvent) {
        if(checkLogin()){

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