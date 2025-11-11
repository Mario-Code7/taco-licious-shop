package com.pluralsight.tacos.model;

import java.util.List;

public class Taco extends MenuItem {
    private String size;
    private String shell;
    private boolean deepFried;
    private List<String> toppings;
    private boolean extraMeat;
    private boolean extraCheese;

    public Taco(double price, String size, String shell, boolean deepFried, List<String> toppings) {
        super(price);
        this.size = size;
        this.shell = shell;
        this.deepFried = deepFried;
        this.toppings = toppings;
    }
    @Override
    public double getPrice() {
        double price = switch (size.toLowerCase()) {
            case "single" -> 3.50;
            case "3-taco" -> 9.00;
            case "burrito" -> 8.50;
            default -> 0;
        };

        double meatPrice = 0;
        double cheesePrice = 0;

        if (extraMeat) {
            meatPrice = switch (size.toLowerCase()) {
                case "single" -> 0.50;
                case "3-taco" -> 1.00;
                case "burrito" -> 1.50;
                default -> 0.0;
            };
        }
        if (extraCheese) {
            cheesePrice = switch (size.toLowerCase()) {
                case "single" -> 0.30;
                case "3-taco" -> 0.60;
                case "burrito" -> 0.90;
                default -> 0.0;
            };
        }
        return price + meatPrice + cheesePrice;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public boolean isDeepFried() {
        return deepFried;
    }

    public void setDeepFried(boolean deepFried) {
        this.deepFried = deepFried;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
    }

    @Override
    public String getDescription() {
        return String.format("Taco (" + size + ", " + shell + ", Deep Fried: " + deepFried + (extraMeat ? ", Extra Meat" : "") + (extraCheese ? ", Extra Cheese" : "") + ") | $" + getPrice());

    }
}
