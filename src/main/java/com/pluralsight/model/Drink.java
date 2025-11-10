package com.pluralsight.model;

public class Drink extends MenuItems {
    public Drink(String size, String type) {
        super(type + " Drink", size, switch (size.toLowerCase()) {
            case "small" -> {
                yield 2.00;
            }
            case "medium" -> {
                yield 2.50;
            }
            case "large" -> {
                yield 3.00;
            }
            default -> 0;
        });
    }

    @Override
    public String getDescription() {
        return name + " (" + size + ")";
    }
}