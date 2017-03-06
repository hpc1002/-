package com.zhijin.okhttp;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zhijin.okhttp.Base.BaseActivity;
import com.zhijin.okhttp.Constants.Constants;
import com.zhijin.okhttp.newsData.NewsData;

import java.util.Random;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.recyclerView)
    EasyRecyclerView recyclerView;

    @Override
    protected void loadViewLayout() {
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void setListener() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void processLogic() {
//
//        recyclerView.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<News>(this) {
//
//            @Override
//            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
//                return new NewsListViewHolder(parent);
//            }
//        });
//        adapter.setMore(R.layout.view_more, this);
        getNetData();
    }

    @Override
    protected Context getActivityContext() {
        return this;
    }


    @Override
    public void onClick(View view) {

    }


    private void getNetData() {
        NewsData newsData = new NewsData(this, recyclerView);
        newsData.getData(Constants.type[new Random().nextInt(Constants.type.length)]);
    }
}
