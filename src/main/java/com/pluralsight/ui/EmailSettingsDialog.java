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

        setLayout(new BorderLayout(10, 10));
        setSize(400, 250);
        setLocationRelativeTo(owner);
