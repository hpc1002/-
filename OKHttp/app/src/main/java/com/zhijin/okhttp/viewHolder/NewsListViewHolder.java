package com.zhijin.okhttp.viewHolder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zhijin.okhttp.R;
import com.zhijin.okhttp.bean.News;

/**
 * Created by hpc on 2017/3/3.
 */

public class NewsListViewHolder extends BaseViewHolder<News> {
    private TextView mNewsTitle;
    private ImageView mNewsIcon;
    private TextView mDate;
    private TextView mAuthor;

    public NewsListViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_news);
        mNewsTitle = $(R.id.news_title);
        mNewsIcon = $(R.id.news_icon);
        mDate = $(R.id.date);
        mAuthor = $(R.id.author);
    }

    @Override
    public void setData(News data) {
        mNewsTitle.setText(data.getTitle());
        mDate.setText(data.getDate());
        mAuthor.setText(data.getAuthor());
        Glide.with(getContext())
                .load(data.getIcon())
                .placeholder(R.mipmap.ic_launcher)
                .into(mNewsIcon);
    }
}
