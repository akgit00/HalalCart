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

