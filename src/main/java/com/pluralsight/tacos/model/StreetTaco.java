package com.pluralsight.tacos.model;

import java.util.ArrayList;
import java.util.List;

public class StreetTaco extends Taco{
    public StreetTaco() {
        super(0.0, "3-taco" , "corn", false, new ArrayList<>(List.of("carne asada", "onions", "salsa verde", "lime wedges")));
    }

    @Override
    public String getDescription() {
        return "Signature Taco: Street Taco\n   " + super.getDescription();
    }

}
