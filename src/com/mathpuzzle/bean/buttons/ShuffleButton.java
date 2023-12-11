package com.mathpuzzle.bean.buttons;

import com.mathpuzzle.base.Button;
import com.mathpuzzle.ui.GameWindow;
import com.mathpuzzle.utils.GameControl;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShuffleButton extends Button {
    public ShuffleButton(GameWindow gameWindow, GameControl control) {
        super();
        button.setText("     打乱     ");
        button.setBackground(new Color(255, 180, 74));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                super.mouseClicked(arg0);
                control.scrambles();
                gameWindow.repaint();
                gameWindow.requestFocus();
            }
        });
    }
}
