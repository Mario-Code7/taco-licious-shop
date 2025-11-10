package com.pluralsight.tacos.data;

import com.pluralsight.tacos.model.MenuItem;

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
            System.out.println("Your order is empty!");
        } else {
            System.out.println("\n ***** Order Summary *****");
            items.stream()
                    .map(MenuItem::getDescription)
                    .forEach(System.out::println);
            System.out.println("Total: $" + getTotalPrice());
        }
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }

}
