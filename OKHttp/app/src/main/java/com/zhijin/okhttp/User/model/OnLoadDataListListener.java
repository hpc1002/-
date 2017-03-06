package com.zhijin.okhttp.User.model;

/**
 * Created by hpc on 2017/1/4.
 */

public interface OnLoadDataListListener<T> {
    void onSuccess(T data);

    void onFailure(Throwable e);
}
