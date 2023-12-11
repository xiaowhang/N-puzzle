package com.mathpuzzle.bean.panels.Interface;

import com.mathpuzzle.base.Panel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends Panel {
    public MainPanel(JPanel btnPanel) {
        super();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(btnPanel);
    }
}
