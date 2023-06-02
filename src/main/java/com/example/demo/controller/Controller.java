package com.example.demo.controller;

import com.example.demo.model.entities.Country;
import com.example.demo.model.entities.CountryDataset;
import com.example.demo.util.DataAttributes;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.ArrayList;
import java.util.List;

public class Controller{
    @FXML
    public MFXComboBox yearComboBox;
    @FXML
    public MFXComboBox attributeComboBox;

    private static List<Country> countryDatasetList;

    public void yearComboClicked(ActionEvent actionEvent){
        switch (Integer.parseInt(String.valueOf(yearComboBox.getValue()))) {
            case 2015 -> year = 2015;
            case 2016 -> year = 2016;
            case 2017 -> year = 2017;
            case 2018 -> year = 2018;
            case 2019 -> year = 2019;
        }
        showAttribute();
    }

    public void attributeComboClicked(ActionEvent actionEvent){
        String s = String.valueOf(attributeComboBox.getValue());
        if(s.equals("HappinessRank")){
            dataAttribute = DataAttributes.HappinessRank;
        }else if(s.equals("HappinessScore")){
            dataAttribute = DataAttributes.HappinessScore;
        }else if(s.equals("Economy")){
            dataAttribute = DataAttributes.Economy;
        }else if(s.equals("LifeExpectancy")){
            dataAttribute = DataAttributes.LifeExpectancy;
        }else if(s.equals("Freedom")){
            dataAttribute = DataAttributes.Freedom;
        }else if(s.equals("GovernmentCorruption")){
            dataAttribute = DataAttributes.GovernmentCorruption;
        }else if(s.equals("Generosity")){
            dataAttribute = DataAttributes.Generosity;
        }
        showAttribute();
    }

    static DataAttributes dataAttribute = DataAttributes.HappinessRank;
    static int year = 2018;

    private void showAttribute(){
        List<List<String>> data = new ArrayList<>();
        for (Country country: countryDatasetList) {
            List<String> countryEntry = new ArrayList<>();
            countryEntry.add(country.getName());
            yearloop:
            for (CountryDataset countryYearDataset: country.getCountryDatasetList()) { //TODO wenn garantiert ist, dass die Reihenfolge immer gleich ist, so kann die Loop durch ein get ersetzt werden
                if(countryYearDataset.getDateOfCollection() == year){
                    switch (dataAttribute){
                        case HappinessRank:
                            WebViewController.changeColorAxis("purple", "#ffffff");
                            countryEntry.add(String.valueOf(countryYearDataset.getHappinessRank()));
                            break;
                        case HappinessScore:
                            WebViewController.changeColorAxis("#ffffff", "green");
                            countryEntry.add(String.valueOf(countryYearDataset.getHappinessScore() * 100.0));
                            break;
                        case Economy:
                            WebViewController.changeColorAxis("#ffffff", "green");
                            countryEntry.add(String.valueOf(countryYearDataset.getEconomy() * 100.0));
                            break;
                        case LifeExpectancy:
                            WebViewController.changeColorAxis("#ffffff", "green");
                            countryEntry.add(String.valueOf(countryYearDataset.getLifeExpectancy()* 100.0));
                            break;
                        case Freedom:
                            WebViewController.changeColorAxis("#ffffff", "green");
                            countryEntry.add(String.valueOf(countryYearDataset.getFreedom()* 100.0));
                            break;
                        case GovernmentCorruption:
                            WebViewController.changeColorAxis("#ffffff", "green");
                            countryEntry.add(String.valueOf(countryYearDataset.getGovernmentCorruption() * 100.0));
                            break;
                        case Generosity:
                            WebViewController.changeColorAxis("#ffffff", "green");
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