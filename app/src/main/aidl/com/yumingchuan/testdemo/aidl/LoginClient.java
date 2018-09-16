package com.yumingchuan.testdemo.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by yumingchuan on 2018/9/17.
 */

public class LoginClient {

    private LoginClient() {

    }

    private static class LoginSinglon {
        public static final LoginClient LOGIN_CLIENT = new LoginClient();
    }

    public static LoginClient getInstance() {
        return LoginSinglon.LOGIN_CLIENT;
    }

    private Login login;

    public void bindServer(Context mContext) {
        Intent intent = new Intent(mContext, LoginServer.class);
        mContext.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            login = Login.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    /**
     * 客户端的登录
     *
     * @param name
     * @param pwd
     */
    public void login(String name, String pwd) {
        if (login != null) {
            try {
                login.login(name, pwd);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }


}
