package com.mathpuzzle.bean.buttons;

import com.mathpuzzle.base.Button;
import com.mathpuzzle.ui.InterfaceWindow;
import com.mathpuzzle.utils.GameControl;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectButton extends Button {
    public SelectButton(String text, Color color, int gameLevel, InterfaceWindow interfaceWindow) {
        super();
        button.setText(text);
        button.setBackground(color);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                GameControl.startGame(gameLevel);
                interfaceWindow.dispose();
            }
        });
    }
}
