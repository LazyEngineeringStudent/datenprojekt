package com.example.demo.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    public MFXComboBox optionsComboBox;
    @FXML
    public FXCollections comboBoxCollection;
    @FXML
    public MFXButton calculateButton;

    public void comboOptionClicked(ActionEvent actionEvent) {
        System.out.println(optionsComboBox.getValue());
    }
}