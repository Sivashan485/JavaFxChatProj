package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main extends Application {
    private final static String applicationInstruction = "Welcome to our application! With this software, you can efficiently manage and store your\n calculations directly on your Personal Computer.";
    private Label label = setWelcomeLabel("WELCOME", Color.web("blue"), Color.web("black"));
    private Label instructionLabel = createLabel(applicationInstruction, 10, 250);
    private static Label results = createLabel("RESULTS: ", 10, 150);

    private static TextField firstEntryField = createEntryField(10,100);
    private static TextField secondEntryField = createEntryField(100,100);

    private Button addButton = createButton("PLUS", 300,100);
    private Button minusButton = createButton("MINUS", 300,150);

    private Button selectFile = createButton("Open File", 400,100);
    private Button saveFile = createButton("Save current Result", 400,150);
    private static String selectedPath = null;
    static ArrayList resultList = new ArrayList<String>();


    @Override
    public void start(Stage primaryStage) throws Exception {


        addButton.setOnMouseClicked(Main::additionClick);

        minusButton.setOnMouseClicked(Main::minusClickEvent);

        selectFile.setOnMouseClicked(Main::selectFileClickEvent);
        saveFile.setOnMouseClicked(Main::selectSaveClickEvent);


        //Create root node
        Group root = new Group();

        //Add label to the scene graph
        root.getChildren().add(label);
        root.getChildren().add(firstEntryField);
        root.getChildren().add(secondEntryField);
        root.getChildren().add(addButton);
        root.getChildren().add(minusButton);
        root.getChildren().add(selectFile);
        root.getChildren().add(saveFile);
        root.getChildren().add(instructionLabel);
        root.getChildren().add(results);

        //Create scene with root node with size
        Scene scene = new Scene(root, 600, 300);

        scene.setFill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#81c483")),     //colors
                new Stop(1, Color.web("#fcc200")))
        );


        //Set stage properties
        primaryStage.setTitle("My first calculator in JavaFX");
        //Add scene to the stage and make it visible
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void selectSaveClickEvent(MouseEvent mouseEvent) {
        try {
            FileWriter fileWriter = new FileWriter(selectedPath);
            String result = null;
            for (Object o : resultList) {

                result = "\n"+result + o;

            }
            fileWriter.write(result);
            fileWriter.close();
            System.out.println("Text saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the text to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void selectFileClickEvent(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");

        Window primaryStage = null;
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            selectedPath = selectedFile.getAbsolutePath();

            // You can perform actions with the selected file here
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void minusClickEvent(MouseEvent mouseEvent) {
        Integer minus = calculateSubtraction(firstEntryField.getText(),secondEntryField.getText());
        results.setText(minus.toString());
        resultList.add(minus);

    }



    private static void additionClick(MouseEvent mouseEvent) {
        Integer sum = calculateAddition(secondEntryField.getText(),firstEntryField.getText());
        results.setText(sum.toString());
        resultList.add(sum);

    }

    private static Integer calculateAddition(String numberA, String numberB){
        return Integer.parseInt(numberA)+Integer.parseInt(numberB);
    }
    private static Integer calculateSubtraction(String numberA, String numberB){
        return Integer.parseInt(numberA)-Integer.parseInt(numberB);
    }

    private static Label createLabel(String text, int positionX, int positionY){
        Label label = new Label();
        label.setText(text);
        label.setLayoutX(positionX);
        label.setLayoutY(positionY);
        label.setMaxWidth(600);
        return label;
    }

    private Label setWelcomeLabel(String text, Color colorA, Color colorB){
        Label label = new Label(text);
        label.setTextFill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, colorA),     //colors
                new Stop(1, colorB)));
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 60));
        return label;
    }

    private Button createButton(String name , int positionX, int positionY){
        Button button = new Button();
        button.setText(name);
        button.setLayoutX(positionX);
        button.setLayoutY(positionY);
        button.setMinWidth(100);

        return button;
    }

    private static TextField createEntryField(int positionX, int positionY){
        TextField entryField = new TextField();
        entryField.setLayoutX(positionX);
        entryField.setLayoutY(positionY);
        entryField.setMinWidth(50);
        entryField.setMaxWidth(70);
        return entryField;
    }


    public static void main(String[] args) {
        launch(args);
    }
}