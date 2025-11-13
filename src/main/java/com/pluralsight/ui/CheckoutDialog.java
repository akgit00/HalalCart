package com.pluralsight.ui;

import com.pluralsight.model.Order;
import com.pluralsight.util.EmailSender;
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

        confirmBtn.addActionListener(this::confirmCheckout);
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
        if (email != null && !email.trim().isEmpty()) {
            try {
                String[] creds = EmailSettingsDialog.getSavedCredentials();
                if (creds == null) {
                    JOptionPane.showMessageDialog(this,
                            "Email not configured. Please open 'Email Settings' first.",
                            "Missing Settings", JOptionPane.WARNING_MESSAGE);
                } else {
                    String sender = creds[0];
                    String password = creds[1];
                    new EmailSender(sender, password).sendReceipt(email.trim(), latestReceipt);
                    PrivateDataLogger.logEmail(email.trim(), latestReceipt);

                    JOptionPane.showMessageDialog(this,
                            "Your receipt has been emailed to " + email,
                            "Email Sent", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error sending email: " + ex.getMessage(),
                        "Email Failed", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(this,
                "Order confirmed! Receipt saved locally.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
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