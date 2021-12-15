package org.example.Info;

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
    private List<AGES> allAges;
    private String unitBatiment;
    private List<String> unitCost;
    private String buildingTime;
    private String livingPoint;



}
