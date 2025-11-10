package com.pluralsight.model;

import java.awt.*;

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
}