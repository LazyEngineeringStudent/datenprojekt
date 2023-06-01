package com.example.demo.controller;

import com.example.demo.model.csv.CSVLoader;
import com.example.demo.model.csv.CSVParser;
import com.example.demo.model.entities.Country;
import com.example.demo.model.entities.CountryDataset;
import com.example.demo.util.DataAttributes;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    public MFXComboBox optionsComboBox;
    @FXML
    public FXCollections comboBoxCollection;
    @FXML
    public MFXButton calculateButton;

    private static List<Country> countryDatasetList;

    public void comboOptionClicked(ActionEvent actionEvent) {
        System.out.println(optionsComboBox.getValue());
    }


    public void btnClicked(){
        showAttribute(2018, DataAttributes.Economy);
    }

    //TODO COMBOBOX Für Jahr

    // TODO COMBOBOX Für Attribut

    private void showAttribute(int year, DataAttributes dataAttribute){
        List<List<String>> data = new ArrayList<>();
        for (Country country: countryDatasetList) {
            List<String> countryEntry = new ArrayList<>();
            countryEntry.add(country.getName());
            yearloop:
            for (CountryDataset countryYearDataset: country.getCountryDatasetList()) { //TODO wenn garantiert ist, dass die Reihenfolge immer gleich ist, so kann die Loop durch ein get ersetzt werden
                if(countryYearDataset.getDateOfCollection() == year){
                    switch (dataAttribute){
                        case HappinessRank:
                            countryEntry.add(String.valueOf(countryYearDataset.getHappinessRank()));
                            break;
                        case HappinessScore:
                            countryEntry.add(String.valueOf(countryYearDataset.getHappinessScore()));
                            break;
                        case Economy:
                            countryEntry.add(String.valueOf(countryYearDataset.getEconomy() * 100.0));
                            break;
                        case LifeExpectancy:
                            countryEntry.add(String.valueOf(countryYearDataset.getLifeExpectancy()* 100.0));
                            break;
                        case Freedom:
                            countryEntry.add(String.valueOf(countryYearDataset.getFreedom()* 100.0));
                            System.out.println("added" + country.getName() + countryYearDataset.getFreedom());
                            break;
                        case GovernmentCorruption:
                            countryEntry.add(String.valueOf(countryYearDataset.getGovernmentCorruption() * 100.0));
                            break;
                        case Generosity:
                            countryEntry.add(String.valueOf(countryYearDataset.getGenerosity() * 100.0));
                    }
                    break yearloop;
                }
            }
            if(countryEntry.size() == 2){
                data.add(countryEntry);
            }
        }
        WebViewController.setData(data, dataAttribute);
    }

    public static  void setCountryDatasetList(List<Country> countryDatasetList1){
        countryDatasetList = countryDatasetList1;
    }
}