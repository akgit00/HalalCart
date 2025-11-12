package com.pluralsight;

import com.pluralsight.ui.MainFrame;

public class MainApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
