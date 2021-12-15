package org.example.Info;

import java.util.ArrayList;

public class Building {
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
    private ArrayList<Integer> ages;
    private String type;
    private ArrayList<String> cost;
    private String time;
    private int hitPoint;
    private int visibility;
    private ArrayList<String> civilisations;


    public Building(String name, ArrayList<Integer> ages, String type, ArrayList<String> cost, String time, int hitPoint, int visibility, ArrayList<String> civilisations) {
        this.name = name;
        this.ages = ages;
        this.type = type;
        this.cost = cost;
        this.time = time;
        this.hitPoint = hitPoint;
        this.visibility = visibility;
        this.civilisations = civilisations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getAges() {
        return ages;
    }

    public void setAges(ArrayList<Integer> ages) {
        this.ages = ages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getCost() {
        return cost;
    }

    public void setCost(ArrayList<String> cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
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

