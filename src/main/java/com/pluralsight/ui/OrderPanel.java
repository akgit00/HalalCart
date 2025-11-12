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
        addPlateBtn.addActionListener(e -> addPlate());
        addDrinkBtn.addActionListener(e -> addDrink());
        addSideBtn.addActionListener(e -> addSide());
    }

    //--------helper methods go here--------

    private void addPlate() {
        PlateDialog dialog = new PlateDialog((Frame) SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            HalalPlate plate = dialog.getPlate();
            order.addItem(plate);
            refreshList();
        }
    }

    private void addDrink() {
        DrinkDialog dialog = new DrinkDialog((Frame) SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            Drink drink = dialog.getDrink();
            order.addItem(drink);
            refreshList();
        }
    }

    private void addSide() {
        SideDialog dialog = new SideDialog((Frame) SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            Side side = dialog.getSide();
            order.addItem(side);
            refreshList();
        }
    }

    private void checkout() {
        order.saveReceipt();
        JOptionPane.showMessageDialog(this,
                "Receipt saved!\nTotal: $" + String.format("%.2f", order.getTotal()),
                "Order Complete",
                JOptionPane.INFORMATION_MESSAGE);
        frame.endOrder();
    }

    private void cancelOrder() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Cancel this order?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            frame.endOrder();
        }
    }

    private void refreshList() {
        listModel.clear();
        for (MenuItems item : order.getItems()) {
            listModel.addElement(item.toString());
        }
        totalLabel.setText("Total: $" + String.format("%.2f", order.getTotal()));
    }
}
