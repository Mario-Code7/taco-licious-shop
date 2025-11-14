package com.pluralsight.tacos.model;

import java.util.ArrayList;
import java.util.List;

public class StreetTaco extends Taco{

    public StreetTaco() {
        super("Carne Asada", 0.0, "3-Taco", "Corn", false, new ArrayList<>(List.of("Carne Asada", "onions", "salsa", "lime wedges")));
    }

    @Override
    public String getDescription() {
        return "Signature Taco: Street Taco\n   " + super.getDescription();
    }

}
