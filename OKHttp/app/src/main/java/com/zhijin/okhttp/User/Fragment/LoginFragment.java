package com.zhijin.okhttp.User.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhijin.okhttp.Base.BaseFragment;
import com.zhijin.okhttp.R;
import com.zhijin.okhttp.User.JumpLisenter;
import com.zhijin.okhttp.User.presenter.LoginPresenter;
import com.zhijin.okhttp.User.view.LoginView;
import com.zhijin.okhttp.bean.User;

//import net.lemonsoft.lemonbubble.LemonBubble;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by hpc on 2017/1/4.
 */

public class LoginFragment extends BaseFragment implements LoginView {
    @BindView(R.id.user_username)
    EditText userUsername;
    @BindView(R.id.user_pwd)
    EditText userPwd;
    @BindView(R.id.user_login)
    Button userLogin;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.lv_list)
    ListView lvList;
    private LoginPresenter presenter;
    private String username;
    private String password;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    protected void initListener() {


        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = userUsername.getText().toString();
                password = userPwd.getText().toString();
//               presenter.LoadData(username,password);
                if (getActivity() instanceof JumpLisenter) {
                    ((JumpLisenter) getActivity()).jump();
                }
//                OkHttpUtils
//                        .post()//
//                        .url(Constants.LoginUrl)//
//                        .addParams("username", username)//
//                        .addParams("password", password)//
//                        .build()//
//                        .execute(new StringCallback() {
//                            @Override
//                            public void onError(Call call, Exception e, int id) {
//                                System.out.println("--------错误---------" + e);
//                            }
//
//                            @Override
//                            public void onResponse(String response, int id) {
//                                User user = new Gson().fromJson(response, User.class);
//                                int code = user.code;
//                                String name = user.name;
//                                System.out.println("-------" + code);
//                                System.out.println("-------" + name);
//                                User.Msg msg = user.msg;
//                                System.out.println("-------" + msg);
//                                String email = msg.email;
//                                System.out.println("-------" + email);
//                                List<User.Course> course = user.course;
//                                System.out.println("-------" + course);
//                                for (int i = 0; i < course.size(); i++) {
//                                    System.out.println("-------" + course.get(i).name);
//                                    for (int j = 0; j < course.get(i).period.size(); j++) {
//                                        System.out.println("-------" + course.get(i).period.get(j).created_at);
//                                    }
//                                }
//                            }
//                        });

            }
        });
    }

    @Override
    protected void initData() {
        presenter = new LoginPresenter(this);
//        presenter.LoadData(username, password);

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void newDatas(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            String codes = jsonObject.getString("code");
            System.out.println("-------" + data);
            if (codes.equals("3")) {
                Toast.makeText(getActivity(), jsonObject.getString("msg"), Toast.LENGTH_LONG).show();
                return;
            } else if (codes.equals("0")) {
                User user = new Gson().fromJson(data, User.class);
                int code = user.code;
                String name = user.name;
                System.out.println("-------" + code);
                System.out.println("-------" + name);
                User.Msg msg = user.msg;
                System.out.println("-------" + msg);
                String email = msg.email;
                System.out.println("-------" + email);
                List<User.Course> course = user.course;
                System.out.println("-------" + course);
                for (int i = 0; i < course.size(); i++) {
                    System.out.println("-------" + course.get(i).name);
                    for (int j = 0; j < course.get(i).period.size(); j++) {
                        System.out.println("-------" + course.get(i).period.get(j).created_at);
                    }
                }
                System.out.println("-----------" + data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void showLoadFailMsg() {

    }
}
