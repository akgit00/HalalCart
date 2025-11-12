package com.pluralsight.ui;

import com.pluralsight.model.Drink;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrinkDialog extends JDialog {
    private Drink drink;
    private boolean confirmed = false;

    private final JComboBox<String> sizeBox;
    private final JComboBox<String> flavorBox;

    public DrinkDialog(Frame owner) {
        super(owner, "Select a Drink", true);
        setSize(300, 200);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(owner);

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        sizeBox = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        flavorBox = new JComboBox<>(new String[]{"Coke", "Sprite", "Water", "Fanta", "Iced Tea"});

        form.add(labeled("Size:", sizeBox));
        form.add(labeled("Flavor:", flavorBox));
        add(form, BorderLayout.CENTER);

        JPanel btns = new JPanel();
        JButton addBtn = new JButton("Add Drink");
        JButton cancelBtn = new JButton("Cancel");
        btns.add(addBtn);
        btns.add(cancelBtn);
        add(btns, BorderLayout.SOUTH);

        addBtn.addActionListener(this::onConfirm);
        cancelBtn.addActionListener(e -> dispose());
    }

    //this will help properly label boxes
    private JPanel labeled(String text, JComponent c) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(new JLabel(text));
        p.add(c);
        return p;
    }

    //what happens when the customer checks a box while selecting a drink?
    private void onConfirm(ActionEvent e) {
        String size = ((String) sizeBox.getSelectedItem()).toLowerCase();
        String flavor = (String) flavorBox.getSelectedItem();

        drink = new Drink(size, flavor);
        confirmed = true;
        dispose();
    }
}