package com.mathpuzzle.bean.buttons;

import com.mathpuzzle.base.Button;
import com.mathpuzzle.ui.GameWindow;
import com.mathpuzzle.ui.InterfaceWindow;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BackButton extends Button {
    public BackButton(GameWindow gameWindow) {
        super();
        button.setText("     返回     ");
        button.setBackground(new Color(255, 209, 145));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                super.mouseClicked(arg0);
                gameWindow.dispose();
                new InterfaceWindow();
            }
        });
    }
}
