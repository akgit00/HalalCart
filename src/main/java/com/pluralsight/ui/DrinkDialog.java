package com.pluralsight.ui;

import com.pluralsight.model.Drink;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrinkDialog extends JDialog {
    private Drink drink;
    private boolean confirmed = false;

    public DrinkDialog(Frame owner) {
        super(owner, "Select a Drink", true);
        setSize(300, 200);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(owner);
    }
}