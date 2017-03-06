package com.zhijin.okhttp.User;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.zhijin.okhttp.Base.BaseActivity;
import com.zhijin.okhttp.Constants.Constants;
import com.zhijin.okhttp.R;
import com.zhijin.okhttp.User.Fragment.FragmentController;

import java.util.HashMap;

import butterknife.BindView;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class UserActivity extends BaseActivity implements JumpLisenter {

    @BindView(R.id.hometab_context)
    FrameLayout hometabContext;
    private FragmentController controller;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_login);
        SMSSDK.initSDK(this, Constants.AppKey, Constants.AppSecret);
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                super.afterEvent(event, result, data);
                if (result == SMSSDK.RESULT_COMPLETE) {
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    // 提交用户信息, 提交的资料将当作“通信录好友”功能的建议资料。
                    registerUser(country, phone);

                    //在验证过后可以处理自己想要的操作
                    Log.v("TAG", "success...");
                }
            }
        });
        registerPage.show(UserActivity.this);
        controller = FragmentController.getInstance(this, R.id.hometab_context);
        controller.showFragment(0);
    }

    private void registerUser(String country, String phone) {
        //提交的资料将当作“通信录好友”功能的建议资料。
        String uid = "1223";
        String nickName = "hpc";
        SMSSDK.submitUserInfo(uid, nickName, null, country, phone);
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FragmentController.onDestroy();
    }

    @Override
    public void jump() {
        controller.showFragment(2);
    }
}
