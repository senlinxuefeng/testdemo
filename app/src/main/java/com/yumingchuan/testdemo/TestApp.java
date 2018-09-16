package com.yumingchuan.testdemo;

import android.app.Application;

/**
 * Created by yumingchuan on 2018/9/17.
 */

public class TestApp extends Application {

    private static TestApp mContext;

    public static TestApp getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
