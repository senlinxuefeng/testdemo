package com.yumingchuan.testdemo.main;


import com.yumingchuan.testdemo.javatt.TestJava1;
import com.yumingchuan.testdemo.algorithm.ArrayStack;
import com.yumingchuan.testdemo.algorithm.QuickSort;
import com.yumingchuan.testdemo.single.EnumSingleton;
import com.yumingchuan.testdemo.utils.LogUtils;

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

        //枚举单例:https://www.jianshu.com/p/4e8ca4e2af6c
        EnumSingleton.getInstance().enumTest();
        EnumSingleton.getInstance().doSomething();

        //快速排序
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{11, 9, 3, 5, 0};
        quickSort.quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            LogUtils.i(arr[i] + "");
        }

        //aidl的使用
//        LoginClient.getInstance().bindServer(TestApp.getInstance());

        //生产者消费者


    }
}
