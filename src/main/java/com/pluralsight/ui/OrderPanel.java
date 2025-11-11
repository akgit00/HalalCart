package com.pluralsight.ui;

import com.pluralsight.model.*;
import com.pluralsight.model.MenuItems;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {

    private final MainFrame frame;
    private final Order order;
    private final DefaultListModel<String> listModel;
    private final JList<String> itemList;
    private final JLabel totalLabel;

    public OrderPanel(MainFrame frame, Order order) {
        this.frame = frame;
        this.order = order;
