package com.mathpuzzle.ui;

import com.mathpuzzle.bean.buttons.ExitButton;
import com.mathpuzzle.bean.buttons.SelectButton;
import com.mathpuzzle.bean.panels.Interface.ButtonPanel;
import com.mathpuzzle.bean.panels.Interface.MainPanel;

import javax.swing.*;
import java.awt.*;

public class InterfaceWindow extends JFrame {
    private final JPanel mainPanel;
    private final JPanel btnPanel;

    public InterfaceWindow() {
        btnPanel = new ButtonPanel().getPanel(); // 设置按钮面板

        addButton(); // 添加按钮

        mainPanel = new MainPanel(btnPanel).getPanel(); // 设置主面板

        launchPanel(); // 启动面板
    }

    private void addButton() {
        // 设置按钮
        JButton easyButton = new SelectButton("    简单    ", new Color(255, 233, 87), 3, this).getButton();
        JButton normalButton = new SelectButton("    普通    ", new Color(242, 159, 63), 4, this).getButton();
        JButton hardButton = new SelectButton("    困难    ", new Color(242, 117, 63), 6, this).getButton();
        JButton hellButton = new SelectButton("    地狱    ", new Color(232, 126, 81), 10, this).getButton();
        JButton exitButton = new ExitButton().getButton();

        // 添加按钮
        JButton[] buttons = {easyButton, normalButton, hardButton, hellButton, exitButton};
        for (JButton button : buttons) {
            btnPanel.add(Box.createVerticalStrut(10)); // 设置按钮间距
            btnPanel.add(button);
        }
    }

    private void launchPanel() {
        setUndecorated(true); // 去除窗口边框
        setSize(300, 300);
        setLocationRelativeTo(null); // 设置窗口居中
        setBackground(new Color(0, 0, 0, 0)); // 设置背景透明
        setFocusable(true);// 设置窗口可获得焦点
        add(mainPanel);// 添加面板
        setVisible(true);// 设置窗口可见
    }
}
