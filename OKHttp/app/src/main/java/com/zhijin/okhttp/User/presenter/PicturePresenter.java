package com.zhijin.okhttp.User.presenter;

import android.graphics.Bitmap;

import com.zhijin.okhttp.User.model.OnLoadDataListListener;
import com.zhijin.okhttp.User.model.PictureModel;
import com.zhijin.okhttp.User.view.PictureView;

/**
 * Created by hpc on 2017/1/6.
 */

public class PicturePresenter implements OnLoadDataListListener<Bitmap>{

    private PictureModel mModel;
    private PictureView mView;

    public PicturePresenter(PictureView mView) {
        this.mView = mView;
        this.mModel=new PictureModel();
        mView.showProgress();
    }

    public void LoadData(){
        mModel.LoadData(this);
    }

    @Override
    public void onSuccess(Bitmap data) {
        mView.newDatas(data);
        mView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mView.showLoadFailMsg();
    }
}
