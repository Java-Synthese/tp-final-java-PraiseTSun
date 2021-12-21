package org.example.Info;

public class UnitsSection {
    private String name;
    private Unit[] results;


    public UnitsSection() {
        this.name = null;
        this.results = null;
    }

    public UnitsSection(String name, Unit[] results) {
        this.name = name;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit[] getResults() {
        return results;
    }

    public void setResults(Unit[] results) {
        this.results = results;
    }
}
