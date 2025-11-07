package com.pluralsight.tacos.model;

import java.util.List;

public class Taco extends MenuItem {
    private String size;
    private String shell;
    private boolean deepFried;
    private List<String> Toppings;

    public Taco(double price, String name, String size, String shell, boolean deepFried, List<String> toppings) {
        super(price, name);
        this.size = size;
        this.shell = shell;
        this.deepFried = deepFried;
        Toppings = toppings;
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
        return Toppings;
    }

    public void setToppings(List<String> toppings) {
        Toppings = toppings;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
