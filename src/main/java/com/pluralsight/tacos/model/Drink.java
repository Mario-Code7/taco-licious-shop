package com.pluralsight.tacos.model;

public class Drink extends MenuItem {
    private String size;
    private String flavor;

    public Drink(double price, String size, String flavor) {
        super(price);
        this.size = size;
        this.flavor = flavor;
    }


    @Override
    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
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
        return String.format("Drink (%s,%s)", size, flavor);
    }
}
