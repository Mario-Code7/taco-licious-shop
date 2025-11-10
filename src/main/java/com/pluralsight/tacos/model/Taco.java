package com.pluralsight.tacos.model;

import java.util.List;
import java.util.stream.Collectors;

public class Taco extends MenuItem {
    private String size;
    private String shell;
    private boolean deepFried;
    private List<String> toppings;

    public Taco(String name, double price, String size, String shell, boolean deepFried, List<String> toppings) {
        super(name, price);
        this.size = size;
        this.shell = shell;
        this.deepFried = deepFried;
        this.toppings = toppings;
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
        toppings = toppings;
    }

    @Override
    public String getDescription() {
        String topping = toppings.stream().collect(Collectors.joining(", "));
        return String.format("%s Taco [%s,%s, Deep Fried: %s] - $%.2f", getName(), size, shell, deepFried ? "Yes" : "No", getPrice()) + (toppings.isEmpty() ? "" : "\nToppings: " + toppings);
    }
}
