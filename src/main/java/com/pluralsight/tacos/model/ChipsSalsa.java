package com.pluralsight.tacos.model;

public class ChipsSalsa extends MenuItem {
    private String salsaType;
    private String chipType;

    public ChipsSalsa(double price, String salsaType, String chipType) {
        super(price);
        this.salsaType = salsaType;
        this.chipType = chipType;
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

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    @Override
    public String getDescription() {
        return String.format("Chips & Salsa (%s, %s)", chipType, salsaType);
    }
}
