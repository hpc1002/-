package com.zhijin.okhttp.application;

import android.app.Application;

import com.zhijin.okhttp.Constants.Constants;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.smssdk.SMSSDK;
import okhttp3.OkHttpClient;

/**
 * Created by hpc on 2017/1/4.
 */

public class OkApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);


    }
}
