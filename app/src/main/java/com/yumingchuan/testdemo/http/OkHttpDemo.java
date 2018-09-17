package com.yumingchuan.testdemo.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yumingchuan on 2018/9/17.
 */

public class OkHttpDemo {
    public void dsfsd() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("")
                .build();
        try {
//            Response response = client.newCall(request).execute();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
