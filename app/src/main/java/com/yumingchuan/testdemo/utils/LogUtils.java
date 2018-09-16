package com.yumingchuan.testdemo.utils;

/**
 * Created by yumingchuan on 2018/9/16.
 */

public class LogUtils {

    private static boolean isDebug = true;

    private static StringBuffer stringBuffer = new StringBuffer();

    public static void i(String... args) {
        if (!isDebug) {
            return;
        }
        stringBuffer.setLength(0);//清空数据
        for (String temp : args) {
            stringBuffer.append(temp + "   ");
        }
        System.out.print(stringBuffer.toString() + "\n");//10,13
    }
}
