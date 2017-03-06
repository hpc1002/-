package com.zhijin.okhttp.User.model;

import android.graphics.Bitmap;

import com.zhijin.okhttp.Constants.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import okhttp3.Call;

/**
 * Created by hpc on 2017/1/6.
 */

public class PictureModel {
    public void LoadData(final OnLoadDataListListener listener){
        OkHttpUtils
                .get()
                .url(Constants.PicUrl)
                .tag(this)
                .build()
                .connTimeOut(2000)
                .readTimeOut(2000)
                .writeTimeOut(2000)
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailure(e);
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        listener.onSuccess(response);
                    }
                });
    }
}
