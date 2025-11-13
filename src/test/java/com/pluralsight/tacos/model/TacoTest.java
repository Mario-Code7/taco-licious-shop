package com.pluralsight.tacos.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TacoTest {
    @Test
    void testingSingleTacoPrice() {
        Taco taco = new Taco(0.0, "single", "corn", false, new ArrayList<>(List.of("lettuce")));

        double price = taco.getPrice();

        assertEquals(3.50, price, "Price for a single taco should be 3.50");
    }

    @Test
    void testTacoWithExtras() {
        Taco taco = new Taco(0.0, "single", "corn", false, new ArrayList<>(List.of("lettuce")));
        taco.setExtraMeat(true);
        taco.setExtraCheese(true);

        double price = taco.getPrice();

        assertEquals(4.30, price, "Price should include extra meat (+0.50) and cheese (+0.30)");
    }

}