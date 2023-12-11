package com.mathpuzzle.utils;

import java.util.Random;

public class GetArray {
    static public int[][] Array;

    static public int[][] getNewArray(int num) {
        Array = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                Array[i][j] = i * num + j;
            }
        }

        shuffle(new Random());
        while (!FeasibilityCheck.isOK(Array)) { // 判断是否可还原
            shuffle(new Random());
        }
        return Array;
    }

    // 打乱数组
    static void shuffle(Random random) {
        int n = Array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int random_x = random.nextInt(n);
                int random_y = random.nextInt(n);
                Swap.swap(Array, i, j, random_x, random_y);
            }
        }
    }
}
