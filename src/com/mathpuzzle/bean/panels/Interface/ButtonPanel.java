package com.mathpuzzle.bean.panels.Interface;

import com.mathpuzzle.base.Panel;

import javax.swing.*;

public class ButtonPanel extends Panel {
    public ButtonPanel() {
        super();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
    }
}
