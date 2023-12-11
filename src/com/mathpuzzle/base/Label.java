package com.mathpuzzle.base;

import javax.swing.*;
import java.awt.*;

public class Label {
    protected JLabel tipsLabel;

    public Label() {
        tipsLabel = new JLabel();
        tipsLabel.setFont(new Font("", Font.BOLD, 30)); // 设置字体
    }

    public JLabel getTipsLabel() {
        return tipsLabel;
    }
}
