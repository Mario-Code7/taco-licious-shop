package com.pluralsight.tacos.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void testTotalOfOrder() {
        Order order = new Order();
        Taco taco1 = new Taco("Pollo", 0.0, "single", "corn", false, new ArrayList<>(List.of("lettuce")));
        Taco taco2 = new Taco("Carnitas", 0.0, "3-Taco", "hard-shell", true, new ArrayList<>(List.of("corn")));
        order.addItem(taco1);
        order.addItem(taco2);

        double equals = taco1.getPrice()+ taco2.getPrice();
        assertEquals(equals, order.getTotalPrice());
    }

}