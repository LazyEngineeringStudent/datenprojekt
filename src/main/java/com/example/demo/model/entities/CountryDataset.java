package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDataset {
    public int getDateOfCollection() {
        return dateOfCollection;
    }

    public void setDateOfCollection(int dateOfCollection) {
        this.dateOfCollection = dateOfCollection;
    }

    public double getHappinessRank() {
        return happinessRank;
    }

    public void setHappinessRank(double happinessRank) {
        this.happinessRank = happinessRank;
    }

    public double getHappinessScore() {
        return happinessScore;
    }

    public void setHappinessScore(double happinessScore) {
        this.happinessScore = happinessScore;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getFreedom() {
        return freedom;
    }

    public void setFreedom(double freedom) {
        this.freedom = freedom;
    }

    public double getGovernmentCorruption() {
        return governmentCorruption;
    }

    public void setGovernmentCorruption(double governmentCorruption) {
        this.governmentCorruption = governmentCorruption;
    }

    public double getGenerosity() {
        return generosity;
    }

    public void setGenerosity(double generosity) {
        this.generosity = generosity;
    }

    private int dateOfCollection;
    private double happinessRank;
    private double happinessScore;
    private double economy;
    private double lifeExpectancy;
    private double freedom;
    private double governmentCorruption;
    private double generosity;
}
