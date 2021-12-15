package org.example.Info;

import java.util.ArrayList;
import java.util.List;

public class Unit {
    private enum AGES {
        UNKNOW(0),
        Dark_Age(1),
        Feudal_Age(2),
        Castle_Age(3),
        Imperial_Age(4);

        private final int value;

        AGES(final int newValue){
            value = newValue;
        }

        public int getvalue(){return value;}
    }

    private String name;
    private ArrayList<AGES> allAges;
    private String unitBatiment;
    private ArrayList<String> unitCost;
    private String buildingTime;
    private int livingPoint;
    private int visibility;
    private ArrayList<String> civilisations;

    public Unit(String name, ArrayList<AGES> allAges, String unitBatiment, ArrayList<String> unitCost, String buildingTime, int livingPoint, int visibility, ArrayList<String> civilisations) {
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

    public ArrayList<AGES> getAllAges() {
        return allAges;
    }

    public void setAllAges(ArrayList<AGES> allAges) {
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
