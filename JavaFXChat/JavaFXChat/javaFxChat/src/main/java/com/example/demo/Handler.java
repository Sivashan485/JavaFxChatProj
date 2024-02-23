package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Handler {




    public void addClickEvent(String textA, Label resultLabel) {
        System.out.println(textA);
        resultLabel.setText(textA);


    }

    public void minusClickEvent(MouseEvent mouseEvent) {
    }

    public void selectFileClickEvent(MouseEvent mouseEvent) {
    }

    public void selectSaveClickEvent(MouseEvent mouseEvent) {
    }
}
