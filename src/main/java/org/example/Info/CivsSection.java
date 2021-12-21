package org.example.Info;

public class CivsSection {
    private  String name;
    private Civilisation[] results;

    public CivsSection() {
        this.name = null;
        this.results = null;
    }

    public CivsSection(String name, Civilisation[] results) {
        this.name = name;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Civilisation[] getResults() {
        return results;
    }

    public void setResults(Civilisation[] results) {
        this.results = results;
    }
}
