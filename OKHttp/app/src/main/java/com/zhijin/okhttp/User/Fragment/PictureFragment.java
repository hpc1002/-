package com.zhijin.okhttp.User.Fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhijin.okhttp.Base.BaseFragment;
import com.zhijin.okhttp.R;
import com.zhijin.okhttp.User.presenter.PicturePresenter;
import com.zhijin.okhttp.User.view.PictureView;


import butterknife.BindView;

/**
 * Created by hpc on 2017/1/6.
 */

public class PictureFragment extends BaseFragment implements PictureView {
    @BindView(R.id.iv_pic)
    ImageView ivPic;
    private PicturePresenter presenter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_picture, container, false);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        presenter = new PicturePresenter(this);
        presenter.LoadData();
    }

    @Override
    public void showProgress() {
//        LemonBubble.showRoundProgress(PictureFragment.this, "加载中...");
//        LemonBubble.showRight(PictureFragment.this, "我就是要加载",2000);
    }

    @Override
    public void hideProgress() {
//        LemonBubble.hide();
    }

    @Override
    public void newDatas(final Bitmap data) {
//        Glide.with(this)
//                .load(Constants.PicUrl)
//                .crossFade()
//                .placeholder(R.mipmap.ic_launcher)
//                .into(ivPic);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ivPic.setImageBitmap(data);
            }
        }, 4000);
        ivPic.setOnKeyListener(backListener);
    }

    @Override
    public void showLoadFailMsg() {

    }

    private View.OnKeyListener backListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                if (i == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
            }
            return false;
        }
    };

}
