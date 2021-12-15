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
    private String livingPoint;


    public Unit() {
        this.name = "Unknow";
        this.allAges = new ArrayList<>();
        this.unitBatiment = "None";
        this.unitCost = new ArrayList<>();
        this.buildingTime = "0";
        this.livingPoint = "None";
    }


    public Unit(String name, ArrayList<AGES> allAges, String unitBatiment, ArrayList<String> unitCost, String buildingTime, String livingPoint) {
        this.name = name;
        this.allAges = allAges;
        this.unitBatiment = unitBatiment;
        this.unitCost = unitCost;
        this.buildingTime = buildingTime;
        this.livingPoint = livingPoint;
    }
}
