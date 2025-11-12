package com.pluralsight.tacos.model;

public abstract class  MenuItem implements PricedItem {
    private double price;

    public MenuItem(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MenuItem{");
        sb.append("price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public abstract String getDescription();
}
