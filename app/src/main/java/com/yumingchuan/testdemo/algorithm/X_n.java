package com.yumingchuan.testdemo.algorithm;

/**
 * Created by yumingchuan on 2018/9/17.
 * java 计算x的n次方
 */

public class X_n {

    public static int power(int i, int j) {
        int y = 0;
        if (j == 0) {
            y = 1;
        } else {
            y = power(i, j / 2);
            y = y * y;
            if (j % 2 != 0) {
                y = y * i;
            }
        }
        return y;
    }
}
