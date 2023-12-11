package com.mathpuzzle.base;

import javax.swing.*;
import java.awt.*;

public class Button {
    protected JButton button;

    public Button() {
        button = new JButton();
        button.setFont(new Font("楷体", Font.BOLD, 30));
        button.setFocusPainted(false);
    }

    public JButton getButton() {
        return button;
    }
}
