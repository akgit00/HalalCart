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