package com.zhijin.okhttp.User.model;

import com.zhijin.okhttp.Constants.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by hpc on 2017/1/4.
 */

public class LoginModel {
    public void LoadData(String username, String password, final OnLoadDataListListener listener) {
      OkHttpUtils.post()
              .url(Constants.LoginUrl)
              .addParams("username",username)
              .addParams("password",password)
              .build()
              .execute(new StringCallback() {
                  @Override
                  public void onError(Call call, Exception e, int id) {
                      listener.onFailure(e);
                  }

                  @Override
                  public void onResponse(String response, int id) {
                      listener.onSuccess(response);

                  }
              });
    }
}
