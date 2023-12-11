package com.mathpuzzle.utils;

import com.mathpuzzle.ui.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameControl {
    private final GameWindow gameWindow;
    private int moveCount;
    private final Map<Integer, int[]> directionMap;

    public GameControl(GameWindow frame) {
        gameWindow = frame;
        directionMap = new HashMap<>();
        directionMap.put(87, new int[]{1, 0});  // 上 W
        directionMap.put(38, new int[]{1, 0});  // 上 ↑
        directionMap.put(83, new int[]{-1, 0});   // 下 S
        directionMap.put(40, new int[]{-1, 0});   // 下 ↓
        directionMap.put(65, new int[]{0, 1});  // 左 A
        directionMap.put(37, new int[]{0, 1});  // 左 ←
        directionMap.put(68, new int[]{0, -1});   // 右 D
        directionMap.put(39, new int[]{0, -1});   // 右 →
    }

    // 重置
    public void scrambles() {
        int[][] arr = GetArray.getNewArray(gameWindow.size);
        updateArr(arr);
        gameWindow.tipsLabel.setText("  用  W S A D 移 动 方 块   ");
        gameWindow.moveFlag = true;
        moveCount = 0;
    }

    // 更新界面
    private void updateArr(int[][] arr) {
        int n = gameWindow.size;
        int total = n * n;
        for (int i = 0; i < total; i++) {
            if (arr[i / n][i % n] != 0) {
                gameWindow.cardLabels.get(i).setBackground(new Color(118, 190, 103));
                gameWindow.cardLabels.get(i).setText(Integer.toString(arr[i / n][i % n]));
                gameWindow.cardLabels.get(i).setOpaque(true);
            } else {
                gameWindow.cardLabels.get(i).setText(" ");
                gameWindow.cardLabels.get(i).setOpaque(false);
            }
        }
    }

    // 移动
    public void move(int[][] arr, int key, int n) {
        int row = 0, col = 0;

        getIndex0:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    row = i;
                    col = j;
                    break getIndex0;
                }
            }
        }

        int[] direction = directionMap.get(key);
        if (direction != null) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                return;
            }

            operator(arr, row, col, newRow, newCol);
        }

        updateArr(arr);
    }

    private void operator(int[][] array, int i, int j, int x, int y) {
        Swap.swap(array, i, j, x, y);

        moveCount++;
        if (win(array)) {
            gameWindow.tipsLabel.setText(" 恭 喜 通 关 ");
            gameWindow.moveFlag = false;
        } else {
            gameWindow.tipsLabel.setText(" 移 动 步 数  ：" + moveCount);
        }
    }

    // 判断是否通关
    private boolean win(int[][] arr) {
        int n = gameWindow.size;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == n - 1) && (j == n - 1)) {
                    return true;
                }
                if (arr[i][j] != i * n + j + 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // 开始游戏
    public static void startGame(int n) {
        JFrame frame = new GameWindow(n);
        new Location(frame);
    }
}
