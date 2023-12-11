package com.mathpuzzle.base;

import javax.swing.*;
import java.awt.*;

public class Panel {
    protected JPanel panel;

    public Panel() {
        panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 0));// 设置背景透明
    }

    public JPanel getPanel() {
        return panel;
    }
}
