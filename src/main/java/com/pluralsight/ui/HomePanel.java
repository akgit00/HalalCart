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

    }
}