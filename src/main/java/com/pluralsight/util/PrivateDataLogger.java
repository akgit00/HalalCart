package com.pluralsight.util;

import com.pluralsight.model.Order;
import com.pluralsight.model.MenuItems;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrivateDataLogger {

    private static final File EMAIL_LOG = new File("private_logs/emails_log.csv");
    private static final File RECEIPT_LOG = new File("private_logs/receipts_log.csv");

    static {
        File dir = new File("private_logs");
        dir.mkdirs();
        try {
            if (!EMAIL_LOG.exists()) {
                try (PrintWriter out = new PrintWriter(new FileWriter(EMAIL_LOG, true))) {
                    out.println("Timestamp,CustomerEmail,ReceiptFile");
                }
            }
            if (!RECEIPT_LOG.exists()) {
                try (PrintWriter out = new PrintWriter(new FileWriter(RECEIPT_LOG, true))) {
                    out.println("Timestamp,Items,Total");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //this method is for formatting the email file
    public static void logEmail(String email, File receiptFile) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try (PrintWriter out = new PrintWriter(new FileWriter(EMAIL_LOG, true))) {
            out.printf("%s,%s,%s%n", timestamp, email, receiptFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logReceipt(Order order, File receiptFile) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        StringBuilder items = new StringBuilder();
        for (MenuItems item : order.getItems()) {
            items.append(item.getName()).append("(").append(item.getSize()).append("); ");
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(RECEIPT_LOG, true))) {
            out.printf("%s,\"%s\",%.2f%n", timestamp, items, order.getTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}