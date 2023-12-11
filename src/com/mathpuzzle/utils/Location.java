package com.mathpuzzle.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Location {
    private final JFrame Frame;
    private int xPos;
    private int yPos;

    public Location(JFrame ck) {
        // TODO Auto-generated constructor stub
        Frame = ck;

        // 为窗口添加鼠标按下事件
        Frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mousePressed(e);

                // 记录鼠标按下时的坐标
                xPos = e.getX();
                yPos = e.getY();

                // 使窗口置顶
                if (!Location.this.Frame.isFocusable()) {
                    Location.this.Frame.setFocusable(true);
                }

                // 使窗口获得焦点
                if (!Location.this.Frame.isFocusOwner()) {
                    Location.this.Frame.requestFocus();
                }
            }

            // 鼠标释放时恢复默认光标
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseReleased(e);

                // 恢复默认光标
                Location.this.Frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // 为窗口添加鼠标拖拽事件
        Location.this.Frame.addMouseMotionListener(new MouseAdapter() {
            // 鼠标拖拽时改变窗口位置
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Location.this.Frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                Location.this.Frame.setLocation(e.getX() - xPos + Location.this.Frame.getLocation().x, e.getY() - yPos + Location.this.Frame.getLocation().y);
            }
        });
    }
}
