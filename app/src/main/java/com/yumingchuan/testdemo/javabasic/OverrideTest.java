package com.yumingchuan.testdemo.javabasic;

import com.yumingchuan.testdemo.utils.LogUtils;

/**
 * Created by yumingchuan on 2018/9/18.
 */

public class OverrideTest {

    public class Person {

        private void go() {
            LogUtils.i("Person:go");
        }

        protected void eat(String foodName) {
            LogUtils.i("Person:eat");
        }

        public void sleep() {
            LogUtils.i("Person:sleep");
        }

    }

    /**
     * protected---->private 不可以
     * protected---->protected 可以
     * protected---->public 可以的
     */
    public class Man extends Person {
        @Override
        public void eat(String foodName) {
            super.eat(foodName);
            LogUtils.i("Man:eat");
        }


        @Override
        public void sleep() {
            super.sleep();
            LogUtils.i("Man:sleep");
        }
    }

}
