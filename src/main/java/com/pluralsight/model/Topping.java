package com.pluralsight.model;

public class Topping {
    private String name;
    private boolean premium;
    private double[] priceBySize;

    public Topping(String name, boolean premium, double[] priceBySize) {
        this.name = name;
        this.premium = premium;
        this.priceBySize = priceBySize;
    }
}