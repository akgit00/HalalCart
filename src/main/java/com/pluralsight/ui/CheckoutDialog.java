package com.pluralsight.ui;

import com.pluralsight.model.Order;
import com.pluralsight.util.PrivateDataLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class CheckoutDialog extends JDialog {
    private final Order order;

    public CheckoutDialog(Frame owner, Order order) {
        super(owner, "Checkout", true);
        this.order = order;

        JLabel title = new JLabel("Checkout", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JLabel totalLabel = new JLabel("Total: $" + String.format("%.2f", order.getTotal()), SwingConstants.CENTER);
        totalLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(totalLabel, BorderLayout.CENTER);

        JButton confirmBtn = new JButton("Confirm & Email Receipt");
        confirmBtn.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(confirmBtn, BorderLayout.SOUTH);
    }

    //this will handle sending out the confirmation email
    private void confirmCheckout(ActionEvent e) {
        order.saveReceipt();
        File latestReceipt = getLatestReceiptFile();
        PrivateDataLogger.logReceipt(order, latestReceipt);

        String email = JOptionPane.showInputDialog(this,
                "Enter your email address to receive your receipt:",
                "Email Receipt",
                JOptionPane.PLAIN_MESSAGE);

    }

    private File getLatestReceiptFile() {
        File dir = new File("receipts");
        File[] files = dir.listFiles((d, n) -> n.startsWith("receipt_"));
        if (files == null || files.length == 0) return null;
        File latest = files[0];
        for (File f : files)
            if (f.lastModified() > latest.lastModified()) latest = f;
        return latest;
    }

}