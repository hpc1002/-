package com.zhijin.okhttp.User.view;

import android.graphics.Bitmap;

/**
 * Created by hpc on 2017/1/6.
 */

public interface PictureView {
    //显示加载页
    void showProgress();

    //关闭加载页
    void hideProgress();

    //加载数据
    void newDatas(Bitmap data);

    //加载失败
    void showLoadFailMsg();
}
