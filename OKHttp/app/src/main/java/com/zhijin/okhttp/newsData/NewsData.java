package com.zhijin.okhttp.newsData;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zhijin.okhttp.Constants.Constants;
import com.zhijin.okhttp.NewsDetailActivity;
import com.zhijin.okhttp.R;
import com.zhijin.okhttp.bean.News;
import com.zhijin.okhttp.viewHolder.NewsListViewHolder;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import okhttp3.Call;

/**
 * Created by hpc on 2017/3/3.
 */

public class NewsData {
    private Context context;
    private EasyRecyclerView recyclerView;
    private RecyclerArrayAdapter<News> adapter;

    public NewsData(Context context, EasyRecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;
    }

    public void getData(String type) {
        OkHttpUtils.get()
                .url(Constants.NewsUrl + "?type=" + type + "&key=" + Constants.JuHeAppKey)
                .tag(context)
                .build()
                .writeTimeOut(2000)
                .readTimeOut(2000)
                .connTimeOut(2000)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("哈哈哈哈", "hahahaha" + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("略略略", "gegegeg" + response);
                        if (response != null) {
                            ArrayList<News> newses = parseData(response);
                            showDataInUi(newses);
                        }
                    }
                });
    }

    private void showDataInUi(final ArrayList<News> myList) {
//        NewsListAdapter newsListAdapter = new NewsListAdapter(context, myList);

        adapter = new RecyclerArrayAdapter<News>(context, myList) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new NewsListViewHolder(parent);
            }
        };
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                News news = adapter.getItem(position);
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("url", news.getUrl());
                context.startActivity(intent);
//                context.overridePendingTransition(0, 0);

            }
        });
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                adapter.clear();
                getData(Constants.type[new Random().nextInt(Constants.type.length)]);
            }
        });
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                getData(Constants.type[new Random().nextInt(Constants.type.length)]);
            }
        });

    }

    private ArrayList<News> parseData(String json) {
        try {
            if (json == null) {
                return null;
            }
            JSONObject jsonObject = new JSONObject(json);
            JSONObject result = jsonObject.getJSONObject("result");
            JSONArray newsListdata = result.getJSONArray("data");
            ArrayList<News> newsDataList = new ArrayList<>();
            for (int i = 0; i < newsListdata.length(); i++) {
                JSONObject jsonObj = newsListdata.getJSONObject(i);
                News news = new News();
                news.title = jsonObj.getString("title");
                news.author = jsonObj.getString("author_name");
                news.date = jsonObj.getString("date");
                news.url = jsonObj.getString("url");
                if (jsonObj.has("thumbnail_pic_s")) {
                    news.icon = jsonObj.getString("thumbnail_pic_s");
                }
                newsDataList.add(news);
            }
            return newsDataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
