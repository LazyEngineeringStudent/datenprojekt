package com.example.demo.model.csv;

import com.example.demo.model.entities.Country;
import com.example.demo.model.entities.CountryDataset;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    private CSVLoader csvLoader = new CSVLoader();
    public List<Country> parseData(List<List<String>> content) {
        List<Country> countryList = new ArrayList<>();
        for (int i = 1; i < content.size(); i++) {
            CountryDataset countryDataset = new CountryDataset();
            Country tempCountry = checkForCountryInList(countryList, content.get(i).get(1));
            countryDataset.setDateOfCollection(Integer.parseInt(content.get(i).get(0)));
            countryDataset.setHappinessRank(Double.parseDouble(content.get(i).get(2)));
            countryDataset.setHappinessScore(Double.parseDouble(content.get(i).get(3)));
            countryDataset.setEconomy(Double.parseDouble(content.get(i).get(4)));
            countryDataset.setLifeExpectancy(Double.parseDouble(content.get(i).get(5)));
            countryDataset.setFreedom(Double.parseDouble(content.get(i).get(6)));
            countryDataset.setGovernmentCorruption(Double.parseDouble(content.get(i).get(7)));
            countryDataset.setGenerosity(Double.parseDouble(content.get(i).get(8)));
            tempCountry.add(countryDataset);
            countryList.add(tempCountry);
        }

        return countryList;
    }

    private Country checkForCountryInList(List<Country> countryList, String targetCountry) {
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getName().equals(targetCountry)) {
                return countryList.get(i);
            }
        }
        return new Country(targetCountry);
    }

    /*private List<Country> sortCountryToList(List<Country> countryList, Country tempCountry){
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).equals(countryList.)) {
                return countryList.get(i);
            }
        }
        return new Country(targetCountry);
    }*/
}
