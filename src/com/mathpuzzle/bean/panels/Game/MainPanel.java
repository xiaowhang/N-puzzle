package com.mathpuzzle.bean.panels.Game;

import com.mathpuzzle.base.Panel;

import javax.swing.*;

public class MainPanel extends Panel {
    public MainPanel(JPanel tipsPanel, JPanel buttonPanel, JPanel cardPanel) {
        super();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(cardPanel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(tipsPanel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(buttonPanel);
    }
}
