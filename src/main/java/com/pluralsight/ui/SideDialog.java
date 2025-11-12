package com.pluralsight.ui;

import com.pluralsight.model.Side;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SideDialog extends JDialog {
    private Side side;
    private boolean confirmed = false;

    private final JComboBox<String> typeBox;

    public SideDialog(Frame owner) {
        super(owner, "Select a Side", true);
        setSize(300, 180);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(owner);

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        typeBox = new JComboBox<>(new String[]{"Fries", "Salad", "Pita Bread", "Falafel Balls"});
        form.add(labeled("Side Item:", typeBox));

        add(form, BorderLayout.CENTER);
    }

    private JPanel labeled(String text, JComponent c) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(new JLabel(text));
        p.add(c);
        return p;
    }
}