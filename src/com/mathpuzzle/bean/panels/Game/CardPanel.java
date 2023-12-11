package com.mathpuzzle.bean.panels.Game;

import com.mathpuzzle.base.Panel;
import com.mathpuzzle.utils.GameControl;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class CardPanel extends Panel {
    public CardPanel(int n, GameControl control, Vector<JLabel> cardLabels) {
        super();
        panel.setLayout(new GridLayout(n, n, 10, 10));

        initCardLabels(n, cardLabels);

        control.scrambles();
        for (JLabel cardLabel : cardLabels) {
            panel.add(cardLabel);
        }
    }

    private void initCardLabels(int n, Vector<JLabel> cardLabels) {
        for (int number = 0; number < n * n; number++) {
            JLabel cardLabel;
            if (number != 0) { // 数字标签
                cardLabel = new JLabel(Integer.toString(number), JLabel.CENTER);
                cardLabel.setOpaque(true);
            } else { // 空白标签
                cardLabel = new JLabel(" ", JLabel.CENTER);
                cardLabel.setOpaque(false);
            }
            cardLabel.setFont(new Font("", Font.BOLD + Font.ITALIC, 5 + 200 / n));
            cardLabels.add(cardLabel);
        }
    }
}
