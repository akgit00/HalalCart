package com.pluralsight.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HalalPlate extends MenuItem {
    //rice or wrap
    private String baseType;
    //chicken, lamb, falafel, combo
    private String protein;
    private List<String> sauces = new ArrayList<>();
    //extra meat or double sauce
    private boolean special;

    public HalalPlate(String size, String baseType, String protein, boolean special) {
        super("Halal Plate", size, 0);
        this.baseType = baseType;
        this.protein = protein;
        this.special = special;
    }
}