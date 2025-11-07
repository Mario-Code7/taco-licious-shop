package com.pluralsight.tacos.model;

public class Drink extends MenuItem {
    private String size;
    private String flavor;

    public Drink(double price, String name, String size, String flavor) {
        super(price, name);
        this.size = size;
        this.flavor = flavor;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
