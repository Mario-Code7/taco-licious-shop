package com.pluralsight.tacos.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreetTaco extends Taco{
    public StreetTaco() {
        super(0.0, "3-taco" , "corn", false, new ArrayList<>(List.of("carne asada", "onions", "salsa verde", "lime wedges")));
    }

    @Override
    public String getDescription() {
//        return "Signature Taco: Street Taco\n   " + "3 Corn, Corn Torillas, Carne Asada, Onions, Cilantro, Salsa Verde, Lime Wedges";
        return toString();
    }
}
