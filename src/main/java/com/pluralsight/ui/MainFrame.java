package com.pluralsight.ui;

import javax.swing.*;
import java.awt.*;

import com.pluralsight.model.Order;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Order currentOrder;

    public MainFrame() {
        setTitle("Ahmad's Halal NYC Cart");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //add home panel here
        HomePanel homePanel = new HomePanel(this);
        mainPanel.add(homePanel, "HOME");

        add(mainPanel);
        setVisible(true);
    }

    //panel for new orders go here (will come back to this later)


    //add a method to go back to home page
    public void goHome() {
        cardLayout.show(mainPanel, "HOME");
    }


    //add a method to finish your order and return to home page
    public void endOrder() {
        currentOrder = null;
        goHome();
    }


    //add a method to display the main panel

    }
