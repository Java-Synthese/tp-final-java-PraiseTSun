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




}
