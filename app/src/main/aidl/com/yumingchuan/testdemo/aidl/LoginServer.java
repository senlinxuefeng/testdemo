package com.yumingchuan.testdemo.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.yumingchuan.testdemo.LogUtils;

/**
 * Created by yumingchuan on 2018/9/17.
 */

public class LoginServer extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private Binder binder = new Login.Stub() {
        @Override
        public void login() throws RemoteException {
            LogUtils.i("客户端调用服务端登录接口");
        }
    };

}
