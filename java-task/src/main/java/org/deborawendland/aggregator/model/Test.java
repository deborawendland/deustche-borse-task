package org.deborawendland.aggregator.model;

import com.opencsv.bean.CsvBindByPosition;

public class Test {

    @CsvBindByPosition(position = 0)
    private String name;
    @CsvBindByPosition(position = 1)
    private String category;
    @CsvBindByPosition(position = 2)
    private String result;

    public Test(String name, String category, String result) {
        this.name = name;
        this.category = category;
        this.result = result;
    }

    public Test(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
