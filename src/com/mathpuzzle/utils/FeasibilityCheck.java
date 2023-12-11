package com.mathpuzzle.utils;

public class FeasibilityCheck {
    // 验证是否有解
    static boolean isOK(int[][] array) {
        int puzzleSize = array.length;

        // 将二维数组转化为一维数组
        int[] temp = new int[puzzleSize * puzzleSize];
        int k = 0;
        for (int[] its : array) {
            for (int it : its) {
                temp[k++] = it;
            }
        }

        //计算逆序对
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[i] > temp[j] && temp[j] != 0) {
                    count++;
                }
            }
        }

        // 如果拼图的列数为奇数，那么逆序对必须为偶数才能有解。
        // 如果拼图的列数为偶数，那么逆序对和空格所在行数之和必须为奇数才能有解。
        if (puzzleSize % 2 == 1) {
            return count % 2 == 0;
        } else {
            int index = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == 0) {
                    index = i;
                    break;
                }
            }
            int row = index / puzzleSize + 1;
            return (count + row) % 2 == 1;
        }
    }
}