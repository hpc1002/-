package com.zhijin.okhttp.User.view;

import com.zhijin.okhttp.bean.User;

/**
 * Created by hpc on 2017/1/4.
 */

public interface LoginView {
    //显示加载页
    void showProgress();

    //关闭加载页
    void hideProgress();

    //加载数据
    void newDatas(String data);

    //加载失败
    void showLoadFailMsg();
}
