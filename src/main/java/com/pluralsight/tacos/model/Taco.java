package com.pluralsight.tacos.model;

import java.util.List;

public class Taco extends MenuItem {
    private String size;
    private String shell;
    private boolean deepFried;
    private List<String> toppings;

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
            default -> getPrice();
        };
        for (String topping : toppings) {
            if (topping.equalsIgnoreCase("carne asada") ||
            topping.equalsIgnoreCase("al pastor")||
            topping.equalsIgnoreCase("carnitas")||
            topping.equalsIgnoreCase("pollo")||
            topping.equalsIgnoreCase("chorizo")||
            topping.equalsIgnoreCase("pescado")) {
                price += switch (size.toLowerCase()) {
                    case "single" -> 1.00;
                    case "3-taco" -> 2.00;
                    case "burrito" -> 3.00;
                    default -> 0;
                };
            } else if (topping.toLowerCase().contains("extra meat")) {
                price += switch (size.toLowerCase()) {
                    case "single" -> 0.50;
                    case "3-taco" -> 1.00;
                    case "burrito" -> 1.50;
                    default -> 0;
                };
            }else if (topping.toLowerCase().contains("cheese")) {
                price += switch (size.toLowerCase()) {
                    case "single" -> 0.75;
                    case "3-taco" -> 1.50;
                    case "burrito" -> 2.25;
                    default -> 0;
                };
            }
        }
        if (deepFried) price += 1.00;
        return price;
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
    public String toString() {
        return "Taco (" + size + ", " + shell + ") - $" + String.format("%.2f", getPrice());
    }
}
