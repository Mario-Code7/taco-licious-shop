package com.pluralsight.tacos.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }


    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }


    public void displayOrder() {
        if (items.isEmpty()) {
            System.out.println("Cart empty!");
        } else {
            System.out.println(getOrderDetails());
        }
    }

    public String getOrderDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("======================================================\n");
        stringBuilder.append("           \uD83E\uDDFE Taco-licious Receipt \uD83E\uDDFE                  \n");
        stringBuilder.append("======================================================\n");
        stringBuilder.append("\n***** Order Summery ****** \n\n");

        int count = 1;
        for (MenuItem item: items) {
            stringBuilder.append(count++)
                    .append(", ")
                    .append(item.getDescription())
                    .append(" | $")
                    .append(String.format("%.2f", item.getPrice()))
                    .append("\n");
        }
        stringBuilder.append("\n------------------------------------------------------\n");
        stringBuilder.append(String.format("Total: $%.2f\n", getTotalPrice()));
        stringBuilder.append("Ruba ba da da Thanks for the Grub, Come Back Again Soon!\n");
        stringBuilder.append("========================================================\n");

        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
