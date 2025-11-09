package com.pluralsight.model;

public abstract class MenuItems {
    protected String name;
    protected String size;
    protected double price;

    //constructor
    public MenuItems(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getDescription();
}
