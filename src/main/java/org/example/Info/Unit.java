package org.example.Info;

import java.util.ArrayList;
import java.util.List;

public class Unit {
    private String name;
    private int[] allAges;
    private String unitBatiment;
    private ArrayList<String> unitCost;
    private String buildingTime;
    private int livingPoint;
    private int visibility;
    private ArrayList<String> civilisations;

    public Unit(String name, int[] allAges, String unitBatiment, ArrayList<String> unitCost, String buildingTime, int livingPoint, int visibility, ArrayList<String> civilisations) {
        this.name = name;
        this.allAges = allAges;
        this.unitBatiment = unitBatiment;
        this.unitCost = unitCost;
        this.buildingTime = buildingTime;
        this.livingPoint = livingPoint;
        this.visibility = visibility;
        this.civilisations = civilisations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getAllAges() {
        return allAges;
    }

    public void setAllAges(int[] allAges) {
        this.allAges = allAges;
    }

    public String getUnitBatiment() {
        return unitBatiment;
    }

    public void setUnitBatiment(String unitBatiment) {
        this.unitBatiment = unitBatiment;
    }

    public ArrayList<String> getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(ArrayList<String> unitCost) {
        this.unitCost = unitCost;
    }

    public String getBuildingTime() {
        return buildingTime;
    }

    public void setBuildingTime(String buildingTime) {
        this.buildingTime = buildingTime;
    }

    public int getLivingPoint() {
        return livingPoint;
    }

    public void setLivingPoint(int livingPoint) {
        this.livingPoint = livingPoint;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public ArrayList<String> getCivilisations() {
        return civilisations;
    }

    public void setCivilisations(ArrayList<String> civilisations) {
        this.civilisations = civilisations;
    }
}
