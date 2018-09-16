package com.yumingchuan.testdemo;

/**
 * Created by yumingchuan on 2018/9/14.
 */

public class AAMainJava {
    public static void main(String[] args) {

        //测试成员变量是否可以赋值
        TestJava1 testJava1 = new TestJava1();
        LogUtils.i(testJava1.a + "：" + testJava1.b);//10,13

        //数组实现堆栈的效果
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(11);
        LogUtils.i("出栈的值为：  ", arrayStack.peek() + "");
        arrayStack.pop();

        //枚举单例
        EnumSingleton.getInstance().doSomething();


    }
}
