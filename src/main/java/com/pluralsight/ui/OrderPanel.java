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
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(itemList);
        add(scrollPane, BorderLayout.CENTER);

        //buttons go here
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JButton addPlateBtn = new JButton("🍛 Add Plate");
        JButton addDrinkBtn = new JButton("🥤 Add Drink");
        JButton addSideBtn = new JButton("🍟 Add Side");
        JButton checkoutBtn = new JButton("💵 Checkout");
        JButton cancelBtn = new JButton("❌ Cancel Order");
        JButton backBtn = new JButton("⬅ Home");

        buttonPanel.add(addPlateBtn);
        buttonPanel.add(addDrinkBtn);
        buttonPanel.add(addSideBtn);
        buttonPanel.add(checkoutBtn);
        buttonPanel.add(cancelBtn);
        buttonPanel.add(backBtn);

        add(buttonPanel, BorderLayout.EAST);

        //label to show the total goes here
        totalLabel = new JLabel("Total: $0.00", SwingConstants.RIGHT);
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(totalLabel, BorderLayout.SOUTH);

        //button action listeners go here


        //--------helper methods go here--------
