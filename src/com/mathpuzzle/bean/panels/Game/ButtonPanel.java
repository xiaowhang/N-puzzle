package com.mathpuzzle.bean.panels.Game;

import com.mathpuzzle.base.Panel;

import javax.swing.*;

public class ButtonPanel extends Panel {
    public ButtonPanel(JButton shuffleButton, JButton backButton) {
        super();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));// 设置按钮面板布局
        panel.add(shuffleButton); // 添加按钮
        panel.add(Box.createHorizontalGlue()); // 添加空白
        panel.add(backButton); // 添加按钮
    }
}
