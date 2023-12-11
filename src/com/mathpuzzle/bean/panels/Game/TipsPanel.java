package com.mathpuzzle.bean.panels.Game;

import com.mathpuzzle.base.Panel;

import javax.swing.*;

public class TipsPanel extends Panel {
    public TipsPanel(JLabel tipsLabel) {
        super();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // 设置提示面板布局
        panel.add(tipsLabel); // 添加提示标签
    }
}
