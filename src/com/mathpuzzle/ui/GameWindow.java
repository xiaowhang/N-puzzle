package com.mathpuzzle.ui;

import com.mathpuzzle.bean.Labels.TipsLabel;
import com.mathpuzzle.bean.buttons.BackButton;
import com.mathpuzzle.bean.buttons.ShuffleButton;
import com.mathpuzzle.bean.panels.Game.ButtonPanel;
import com.mathpuzzle.bean.panels.Game.CardPanel;
import com.mathpuzzle.bean.panels.Game.MainPanel;
import com.mathpuzzle.bean.panels.Game.TipsPanel;
import com.mathpuzzle.utils.GameControl;
import com.mathpuzzle.utils.GetArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serial;
import java.util.Vector;

public class GameWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    public Vector<JLabel> cardLabels = new Vector<>();
    public JLabel tipsLabel;
    public final JPanel mainPanel;
    private boolean pressedFlag;
    private final GameControl control;
    public boolean moveFlag = true;
    public int size;

    public GameWindow(int n) {
        // 初始化变量
        control = new GameControl(this);
        size = n;

        tipsLabel = new TipsLabel().getTipsLabel(); // 设置提示标签

        JButton shuffleButton = new ShuffleButton(this, control).getButton(); // 设置打乱按钮
        JButton backButton = new BackButton(this).getButton(); // 设置返回按钮
        JPanel buttonPanel = new ButtonPanel(shuffleButton, backButton).getPanel(); // 设置按钮面板
        JPanel tipsPanel = new TipsPanel(tipsLabel).getPanel(); // 设置提示面板
        JPanel cardPanel = new CardPanel(size, control, cardLabels).getPanel(); // 设置卡片面板
        mainPanel = new MainPanel(tipsPanel, buttonPanel, cardPanel).getPanel(); // 设置主面板

        launchPanel(); // 启动面板

        // 添加键盘监听事件
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (!GameWindow.this.isFocusable()) { // 判断是否可以获得焦点
                    GameWindow.this.setFocusable(true);
                }
                if (!GameWindow.this.isFocusOwner()) { // 判断是否获得焦点
                    GameWindow.this.requestFocus();
                }
                if (!pressedFlag) {
                    if (e.getKeyCode() == 32) { // 空格
                        control.scrambles();
                    } else if (e.getKeyCode() == 27) { // ESC
                        System.exit(0);
                    } else if (moveFlag) { // 判断是否可以移动
                        control.move(GetArray.Array, e.getKeyCode(), n);
                    }
                    GameWindow.this.repaint();
                    pressedFlag = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                super.keyReleased(arg0);
                pressedFlag = false;
            }
        });
    }

    private void launchPanel() {
        setUndecorated(true); // 去除窗口边框
        add(mainPanel);// 添加面板
        setSize(500, 600);// 设置窗口大小
        setBackground(new Color(0, 0, 0, 0));// 设置背景透明
        setLocationRelativeTo(null);// 设置窗口居中
        setFocusable(true);// 设置窗口可获得焦点
        setVisible(true);// 设置窗口可见
    }
}
