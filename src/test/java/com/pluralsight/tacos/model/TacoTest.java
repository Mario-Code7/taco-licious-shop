package com.pluralsight.tacos.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TacoTest {
    @Test
    void testTacoSinglePrice() {
        Taco taco = new Taco("Pollo",0.0, "single", "corn", false, new ArrayList<>(List.of("lettuce")));

        double price = taco.getPrice();

        assertEquals(3.50, price, "Price single taco = 3.50");
    }

    @Test
    void testExtraInTacos() {
        Taco taco = new Taco("Carne Asada",0.0, "single", "corn", false, new ArrayList<>(List.of("lettuce")));
        taco.setExtraMeat(true);
        taco.setExtraCheese(true);

        double price = taco.getPrice();

        assertEquals(4.30, price, "Price extra meat and cheese -> (+0.50), (+0.30)");
    }

}