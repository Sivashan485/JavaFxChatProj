package com.example.javafxchatproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class homeViewController implements Initializable {
    @FXML
    private ListView<String> userList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Check if userList is properly initialized
        if (userList == null) {
            System.err.println("userList is not properly initialized!");
            return;
        }

        // Set items to userList
        userList.setItems(reloadUserList());        // You can initialize userList here if necessary
    }

    @FXML
    public ObservableList<String> reloadUserList() {
        // Implement logic to reload user list
        // Example:
        ObservableList<String> items = FXCollections.observableArrayList(
                "User 1",
                "User 2",
                "User 3"
        );
        return items;
    }

    @FXML
    private void userSelectClick() {
        if(userSelectedSuccessful()){

        }else{
            createErrorMessageUserSelection();
        }
    }

    private boolean userSelectedSuccessful(){
        String selectedUser = userList.getSelectionModel().getSelectedItem();
        return !("".equals(selectedUser) || selectedUser==null);
    }

    private void createErrorMessageUserSelection(){
        Alert errorMessage = new Alert(Alert.AlertType.WARNING);
        errorMessage.setTitle("JAVAFXCHAT USER SELECTION FAILED");
        errorMessage.setContentText("You have not selected an user, please select a user");
        errorMessage.show();
    }

}
