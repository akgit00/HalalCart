package com.pluralsight.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        File dir = new File("receipts");
        dir.mkdirs();
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        File file = new File(dir, "receipt_" + timestamp + ".txt");
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Halal NYC Cart Receipt");
            out.println("----------------------");
            for (MenuItems item : items) {
                out.println(item);
            }
            out.println("----------------------");
            out.printf("Total: $%.2f%n", getTotal());
            out.println("Thank you for your order!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}