package com.pluralsight.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {

    public HomePanel(MainFrame frame) {
        //layout and dimensions of the home panel
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Halal NYC Cart", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        //new buttons for a new order and to exit panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton newOrderButton = new JButton("New Order");
        JButton exitButton = new JButton("Exit");

        newOrderButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        exitButton.setFont(new Font("SansSerif", Font.PLAIN, 20));

        buttonPanel.add(newOrderButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));

        //event listeners
        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.startNewOrder();
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
    }
}