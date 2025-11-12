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
        double price = 0.0;

        switch (size) {
            case "single":
                price = 3.50;
            case "3-taco":
                price = 9.00;
            case "burrito":
                price = 8.50;
            default:
                price = 3.50;
        }

        switch (size) {
            case "single":
                if (extraMeat) price += 0.50;
                if (extraCheese) price += 0.30;
                break;
            case "3-taco":
                if (extraMeat) price += 1.00;
                if (extraCheese) price += 0.50;
                break;
            case "burrito":
                if (extraMeat) price += 1.50;
                if (extraCheese) price += 0.90;
                break;
        }


//        if (extraCheese) {
//            cheesePrice = switch (size.toLowerCase()) {
//                case "single" -> 0.30;
//                case "3-taco" -> 0.60;
//                case "burrito" -> 0.90;
//                default -> 0.0;
//            };

        if (deepFried) {
            price += 0.50;
        }
        if (this instanceof StreetTaco) {
            price += 9.00;
        } else if (this instanceof SuperBurrito) {
            price += 8.50;
        }
        return price;
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
//        return String.format("Taco (" + size + ", " + shell + ", Deep Fried: " + deepFried + (extraMeat ? ", Extra Meat" : "") + (extraCheese ? ", Extra Cheese" : "") + ") | $" + getPrice());
        StringBuilder description = new StringBuilder();
        description.append("Taco [")
                .append(size)
                .append(", Shell: ")
                .append(shell);
        if (deepFried){
            description.append(", Deep Fried");
        }
        if (!toppings.isEmpty()) {
            description.append(", Toppings: ")
                    .append(String.join(", ", toppings));
        }
        if (extraMeat){
            description.append(", +Extra Meat");
        }
        if (extraCheese) {
            description.append(", + Extra cheese");
        }
        description.append("]");

        return toString();
    }
}