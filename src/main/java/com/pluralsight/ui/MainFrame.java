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
    }

    }
