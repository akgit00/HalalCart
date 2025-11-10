package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class HalalPlate extends MenuItems {
    //rice or wrap
    private String baseType;
    //chicken, lamb, falafel, combo
    private String protein;
    private List<Topping> toppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();
    //extra meat or double sauce
    private boolean special;

    public HalalPlate(String size, String baseType, String protein, boolean special) {
        super("Halal Plate", size, 0);
        this.baseType = baseType;
        this.protein = protein;
        this.special = special;
    }

    //topping
    public void addTopping(Topping t) {
        toppings.add(t);
    }

    //sauce
    public void addSauce(String s) {
        sauces.add(s);
    }

    //define and calculate the price
    public void calculatePrice() {
        double basePrice = switch (size.toLowerCase()) {
            case "small" -> 8.0;
            case "medium" -> 10.0;
            case "large" -> 12.0;
            default -> 0;
        };

        for (Topping t : toppings)
            basePrice += t.getPriceForSize(size);

        if (special) basePrice += 2.0; // extra cost for special

        this.price = basePrice;
    }

    @Override
    public String getDescription() {
        return size + " " + baseType + " with " + protein + ", Toppings: " + toppings + ", Sauces: " + sauces;
    }
}