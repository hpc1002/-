package com.zhijin.okhttp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhijin.okhttp.R;
import com.zhijin.okhttp.bean.News;

import java.util.List;

/**
 * Created by hpc on 2017/3/3.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<News> mNewsBeanList;

    public NewsListAdapter(Context context, List<News> mNewsBeanList) {
        this.context = context;
        this.mNewsBeanList = mNewsBeanList;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(mLayoutInflater.inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {
        holder.mNewsTitle.setText(mNewsBeanList.get(position).getTitle());
        holder.mAuthor.setText(mNewsBeanList.get(position).getAuthor());
        holder.mDate.setText(mNewsBeanList.get(position).getDate());
        Glide.with(context)
                .load(mNewsBeanList.get(position).getIcon())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mNewsIcon);
    }

    @Override
    public int getItemCount() {
        return mNewsBeanList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView mNewsTitle;
        TextView mDate;
        TextView mAuthor;
        ImageView mNewsIcon;

        NewsViewHolder(View itemView) {
            super(itemView);
            mNewsTitle = (TextView) itemView.findViewById(R.id.news_title);
            mDate = (TextView) itemView.findViewById(R.id.date);
            mAuthor = (TextView) itemView.findViewById(R.id.author);
            mNewsIcon = (ImageView) itemView.findViewById(R.id.news_icon);

        }
    }
}
