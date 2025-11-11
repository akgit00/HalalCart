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

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //title
        JLabel title = new JLabel("Current Order", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        //item list go here

        //buttons go here


        //label to show the total goes here

        //button action listeners go here


        //--------helper methods go here--------
