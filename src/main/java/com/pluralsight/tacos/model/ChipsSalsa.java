package com.pluralsight.tacos.model;

public class ChipsSalsa extends MenuItem {
    private String salsaType;

    public ChipsSalsa(double price, String salsaType) {
        super(price);
        this.salsaType = salsaType;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    public String getSalsaType() {
        return salsaType;
    }

    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
    }

    @Override
    public String toString() {
        return  "Chips & " + salsaType + " Salsa - $" + String.format("%.2f", getPrice());
    }
}
