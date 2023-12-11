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

        // Ϊ���������갴���¼�
        Frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mousePressed(e);

                // ��¼��갴��ʱ������
                xPos = e.getX();
                yPos = e.getY();

                // ʹ�����ö�
                if (!Location.this.Frame.isFocusable()) {
                    Location.this.Frame.setFocusable(true);
                }

                // ʹ���ڻ�ý���
                if (!Location.this.Frame.isFocusOwner()) {
                    Location.this.Frame.requestFocus();
                }
            }

            // ����ͷ�ʱ�ָ�Ĭ�Ϲ��
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseReleased(e);

                // �ָ�Ĭ�Ϲ��
                Location.this.Frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // Ϊ������������ק�¼�
        Location.this.Frame.addMouseMotionListener(new MouseAdapter() {
            // �����קʱ�ı䴰��λ��
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Location.this.Frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                Location.this.Frame.setLocation(e.getX() - xPos + Location.this.Frame.getLocation().x, e.getY() - yPos + Location.this.Frame.getLocation().y);
            }
        });
    }
}
