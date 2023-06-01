package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Country {
    public Country(String name){
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public List<CountryDataset> getCountryDatasetList() {
        return countryDatasetList;
    }

    private List<CountryDataset> countryDatasetList = new ArrayList<>();
     public void add(CountryDataset countryDataset){
         this.countryDatasetList.add(countryDataset);
     }
}
