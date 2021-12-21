package org.example.Info;

public class Ages {
    private String name;
    private String[] ages;

    public Ages() {
        this.name = null;
        this.ages = null;
    }

    public Ages(String name, String[] ages) {
        this.name = name;
        this.ages = ages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAges() {
        return ages;
    }

    public void setAges(String[] ages) {
        this.ages = ages;
    }
}
