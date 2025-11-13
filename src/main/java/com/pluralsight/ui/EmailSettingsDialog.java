package com.pluralsight.ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class EmailSettingsDialog extends JDialog {

    private static final File SETTINGS_FILE = new File("private_logs/email_settings.txt");

    private final JTextField emailField;
    private final JPasswordField passwordField;

    public EmailSettingsDialog(Frame owner) {
        super(owner, "Email Settings", true);

        // layout/dimensions
        setLayout(new BorderLayout(10, 10));
        setSize(400, 250);
        setLocationRelativeTo(owner);

        //title for user email config
        JLabel title = new JLabel("Configure Email Sender (Gmail only)", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        //panels for user email address and password
        formPanel.add(new JLabel("Gmail Address:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("App Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        add(formPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton saveBtn = new JButton("💾 Save");
        JButton cancelBtn = new JButton("Cancel");
        btnPanel.add(saveBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);

        // Load existing credentials if any
        loadCredentials();
    }

    //this method is meant to load user credentials
    private void loadCredentials() {

    }

