package com.zhijin.okhttp.User.presenter;

import com.zhijin.okhttp.User.model.LoginModel;
import com.zhijin.okhttp.User.model.OnLoadDataListListener;
import com.zhijin.okhttp.User.view.LoginView;

/**
 * Created by hpc on 2017/1/4.
 */

public class LoginPresenter implements OnLoadDataListListener<String> {

    private LoginModel mModel;
    private LoginView mView;

    public LoginPresenter(LoginView mView) {
        this.mView = mView;
        this.mModel = new LoginModel();
        mView.showProgress();
    }

    public void LoadData(String username, String password) {
        mModel.LoadData(username, password, this);
    }

    @Override
    public void onSuccess(String data) {
        mView.newDatas(data);
        mView.hideProgress();
    }



    @Override
    public void onFailure(Throwable e) {
        mView.showLoadFailMsg();
    }
}
