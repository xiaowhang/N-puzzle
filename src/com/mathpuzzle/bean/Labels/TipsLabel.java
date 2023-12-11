package com.mathpuzzle.bean.Labels;

import com.mathpuzzle.base.Label;

import java.awt.*;

public class TipsLabel extends Label {
    public TipsLabel() {
        super();
        tipsLabel.setText("   用  W S A D 移 动 方 块      "); // 设置提示标签
        tipsLabel.setForeground(new Color(241, 124, 103)); // 设置字体颜色
    }
}
