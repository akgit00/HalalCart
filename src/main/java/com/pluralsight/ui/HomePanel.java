package com.pluralsight.ui;

import com.pluralsight.ui.EmailSettingsDialog;
import com.pluralsight.ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private Image cornerImage;

    public HomePanel(MainFrame frame) {

        //load the NYC image
        cornerImage = new ImageIcon(getClass().getResource("/images/background.png")).getImage();

        //set the beige background
        setBackground(new Color(245, 245, 220));

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Halal NYC Cart", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton newOrderButton = new JButton("New Order 🧾");
        JButton exitButton = new JButton("Exit ❌");
        JButton emailSettingsButton = new JButton("Email Settings");

        newOrderButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        exitButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        emailSettingsButton.setFont(new Font("SansSerif", Font.PLAIN, 20));

        buttonPanel.add(newOrderButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(emailSettingsButton);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));

        //make inner panel transparent so the beige background shows
        buttonPanel.setOpaque(false);

        //event listeners
        newOrderButton.addActionListener(e -> frame.startNewOrder());
        emailSettingsButton.addActionListener(e -> new EmailSettingsDialog(frame).setVisible(true));
        exitButton.addActionListener(e -> System.exit(0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // put the NYC image in top right corner
        if (cornerImage != null) {
            int imgWidth = cornerImage.getWidth(null);
            int imgHeight = cornerImage.getHeight(null);

            int x = getWidth() - imgWidth - 200; // 200 pixels padding from the right
            int y = 0;                          // 0 pixels padding from the top

            g.drawImage(cornerImage, x, y, this);
        }
    }
}