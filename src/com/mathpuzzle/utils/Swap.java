package com.mathpuzzle.utils;

public class Swap {
    // 交换数组元素
    static public void swap(int[][] array, int i, int j, int x, int y) {
        int temp = array[i][j];
        array[i][j] = array[x][y];
        array[x][y] = temp;
    }
}