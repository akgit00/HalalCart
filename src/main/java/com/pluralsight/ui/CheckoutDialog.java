package com.pluralsight.ui;

import com.pluralsight.model.Order;
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

    }

    private File getLatestReceiptFile() {
        File dir = new File("receipts");
        File[] files = dir.listFiles((d, n) -> n.startsWith("receipt_"));

    }
}