package com.pluralsight.ui;

import com.pluralsight.model.Side;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SideDialog extends JDialog {
    private Side side;
    private boolean confirmed = false;