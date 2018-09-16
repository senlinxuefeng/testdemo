package com.yumingchuan.testdemo;

/**
 * Created by yumingchuan on 2018/9/16.
 */

public enum EnumSingleton {
    INSTANCE;
    public void doSomething() {
        System.out.print("枚举单例模式的测试--------");
    }

    public static EnumSingleton getInstance() {
        return EnumSingleton.INSTANCE;
    }
}
