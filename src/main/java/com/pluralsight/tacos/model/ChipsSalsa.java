package com.pluralsight.tacos.model;

public class ChipsSalsa extends MenuItem {
    private String salsaType;

    public ChipsSalsa(double price, String name, String salsaType) {
        super(price, name);
        this.salsaType = salsaType;
    }

    public String getSalsaType() {
        return salsaType;
    }

    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
