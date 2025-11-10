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
    public String getName() { return name; }
    public boolean isPremium() { return premium; }

    public double getPriceForSize(String size) {
        return switch (size.toLowerCase()) {
            case "small" -> {
                yield priceBySize[0];
            }
            case "medium" -> {
                yield priceBySize[1];
            }
            case "large" -> {
                yield priceBySize[2];
            }
            default -> {
                yield 0;
            }
        };
    }
    @Override
    public String toString() {
        return name + (premium ? " (Premium)" : "");
    }
}