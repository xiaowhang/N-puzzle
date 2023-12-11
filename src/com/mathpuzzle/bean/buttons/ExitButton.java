package com.mathpuzzle.bean.buttons;

import com.mathpuzzle.base.Button;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExitButton extends Button {
    public ExitButton() {
        super();
        button.setText("    退出    ");
        button.setBackground(new Color(222, 140, 104));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
    }
}
