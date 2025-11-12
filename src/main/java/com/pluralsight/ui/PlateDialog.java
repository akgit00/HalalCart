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
        setLayout(new BorderLayout(10,10));
        setSize(200, 400);
        setLocationRelativeTo(owner);

        //panel to choose plate options go here

        //size goes here

        //base type goes here

        //protein options go here

        //standard topping options go here

        //special topping options go here

        //sauces go here

        //special options go here