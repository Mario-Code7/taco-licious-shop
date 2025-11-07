package com.pluralsight.tacos.model;

public class ChipsSalsa extends MenuItem {
    private String salsaType;

    public ChipsSalsa(String name, double price, String salsaType) {
        super(name, price);
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
        return getName() + " | Salsa: " + getSalsaType() + " | Price: $" + getPrice();
    }
}
