package com.zhijin.okhttp.User.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.zhijin.okhttp.Base.BaseFragment;
import com.zhijin.okhttp.R;

import butterknife.BindView;

/**
 * Created by hpc on 2017/1/4.
 */

public class RegisterFragment extends BaseFragment {


    @BindView(R.id.reg_username)
    EditText regUsername;
    @BindView(R.id.reg_pwd)
    EditText regPwd;
    @BindView(R.id.reg_login)
    Button regLogin;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

}
