package com.pluralsight.ui;

import com.pluralsight.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class PlateDialog extends JDialog {

    private HalalPlate plate;
    private boolean confirmed = false;

    private final JComboBox<String> sizeBox;
    private final JComboBox<String> baseBox;
    private final JComboBox<String> proteinBox;
    private final JCheckBox specialBox;

    private final JCheckBox[] toppingChecks;
    private final JCheckBox[] premiumChecks;
    private final JCheckBox[] sauceChecks;

    public PlateDialog(Frame owner) {
        super(owner, "Customize Your Halal Plate", true);
        setLayout(new BorderLayout(10, 10));
        setSize(200, 400);
        setLocationRelativeTo(owner);

        //panel to choose plate options go here
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        //size goes here
        sizeBox = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        form.add(labeled("Size:", sizeBox));

        //base type goes here
        baseBox = new JComboBox<>(new String[]{"Rice", "Wrap"});
        form.add(labeled("Base:", baseBox));

        //protein options go here
        proteinBox = new JComboBox<>(new String[]{"Chicken", "Lamb", "Falafel", "Combo"});
        form.add(labeled("Protein:", proteinBox));

        //standard topping options go here
        String[] regularToppings = {"Lettuce", "Tomato", "Onion", "Pickles"};
        toppingChecks = new JCheckBox[regularToppings.length];
        form.add(new JLabel("Regular Toppings:"));
        for (int i = 0; i < regularToppings.length; i++) {
            toppingChecks[i] = new JCheckBox(regularToppings[i]);
            form.add(toppingChecks[i]);
        }

        //special topping options go here
        String[] premiumToppings = {"Extra Meat", "Cheese", "Egg"};
        premiumChecks = new JCheckBox[premiumToppings.length];
        form.add(new JLabel("Premium Toppings:"));
        for (int i = 0; i < premiumToppings.length; i++) {
            premiumChecks[i] = new JCheckBox(premiumToppings[i]);
            form.add(premiumChecks[i]);
        }

        //sauces go here
        String[] sauces = {"White Sauce", "Hot Sauce", "BBQ", "Garlic", "Tahini"};
        sauceChecks = new JCheckBox[sauces.length];
        form.add(new JLabel("Sauces:"));
        for (int i = 0; i < sauces.length; i++) {
            sauceChecks[i] = new JCheckBox(sauces[i]);
            form.add(sauceChecks[i]);
        }

        //special options go here
        specialBox = new JCheckBox("Special (Extra meat / Double sauce + $2)");
        form.add(specialBox);

        add(new JScrollPane(form), BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton confirmBtn = new JButton("Add Plate");
        JButton cancelBtn = new JButton("Cancel");
        btnPanel.add(confirmBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);

        confirmBtn.addActionListener(this::onConfirm);
        cancelBtn.addActionListener(e -> dispose());
    }

    private JPanel labeled(String text, JComponent comp) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(new JLabel(text));
        p.add(comp);
        return p;
    }

    //what happens when the customer checks a box while making a plate?
    private void onConfirm(ActionEvent e) {
        String size = (String) sizeBox.getSelectedItem();
        String base = (String) baseBox.getSelectedItem();
        String protein = (String) proteinBox.getSelectedItem();
        boolean special = specialBox.isSelected();

        plate = new HalalPlate(size.toLowerCase(), base, protein, special);

        // regular toppings
        for (JCheckBox cb : toppingChecks) {
            if (cb.isSelected()) {
                plate.addTopping(new Topping(cb.getText(), false, new double[]{0, 0, 0}));
            }
        }

        // premium toppings
        for (JCheckBox cb : premiumChecks) {
            if (cb.isSelected()) {
                plate.addTopping(new Topping(cb.getText(), true, new double[]{0.75, 1.5, 2.25}));
            }
        }

        // sauces
        for (JCheckBox cb : sauceChecks) {
            if (cb.isSelected()) plate.addSauce(cb.getText());
        }

        plate.calculatePrice();
        confirmed = true;
        dispose();
    }
    public boolean isConfirmed(){ return confirmed; }
    public HalalPlate getPlate(){ return plate; }
}