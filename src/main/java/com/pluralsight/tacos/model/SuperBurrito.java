package com.pluralsight.tacos.model;

import java.util.Arrays;
import java.util.List;

public class SuperBurrito extends Taco{

    public SuperBurrito(){
        super(0.0, "Burrito", "flour", false, Arrays.asList("carnitas", "cheddar", "pico de gallo", "lettuce", "tomatoes", "birria dipped"));
    }

    @Override
    public String getDescription() {
        return "Signature Burrito: Super Burrito\n     " + "Burrito, Flour Torilla, Carnitas, Cheddar, Pico de Gallo, Tomatoes, Birria Dipped";
    }
}
