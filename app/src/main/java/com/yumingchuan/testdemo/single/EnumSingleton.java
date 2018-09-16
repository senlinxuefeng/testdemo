package com.yumingchuan.testdemo.single;

import com.yumingchuan.testdemo.utils.LogUtils;

/**
 * Created by yumingchuan on 2018/9/16.用法是实现接口
 */

public enum EnumSingleton implements EnumInterfaceTest {
    INSTANCE {
        @Override
        public void enumTest() {
            LogUtils.i("枚举单例实现接口的方式------", this.getClass().getMethods()[0].getName());
        }
    };

    /**
     * 枚举里边直接加入方法
     */
    public void doSomething() {
        LogUtils.i("枚举单例模式中直接加入方法--------");
    }

    public static EnumSingleton getInstance() {
        return EnumSingleton.INSTANCE;
    }
}
