package com.zhijin.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.AdLinearLayout)
    LinearLayout AdLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);
    }
}
