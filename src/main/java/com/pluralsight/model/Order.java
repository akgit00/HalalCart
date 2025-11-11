package com.pluralsight.model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private List<MenuItems> items = new ArrayList<>();

    public void addItem(MenuItems item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (MenuItems item : items) total += item.getPrice();
        return total;
    }

    public List<MenuItems> getItems() {
        return items;
    }

    public void saveReceipt() {
        String filename = "receipts/" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Halal NYC Cart Order\n");
            writer.write("=====================\n");
            for (MenuItems item : items)
                writer.write(item + "\n");
            writer.write("\nTotal: $" + String.format("%.2f", getTotal()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}