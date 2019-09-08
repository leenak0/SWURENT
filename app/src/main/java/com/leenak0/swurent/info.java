package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class info extends AppCompatActivity {

    WebView mWebView_info;
    String myUrl = "http://114.70.37.15"; // 접속 URL (내장HTML의 경우 왼쪽과 같이 쓰고 아니면 걍 URL)
    Button info_prev;
    //Button info_reserv;
    Button info_com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info_prev = (Button)findViewById(R.id.info_prev);
        //info_reserv = (Button)findViewById(R.id.info_reserv);
        info_com=(Button)findViewById(R.id.info_com);

        // 웹뷰 셋팅
        mWebView_info = (WebView)findViewById(R.id.webView_info);
        mWebView_info.getSettings().setJavaScriptEnabled(true);

        mWebView_info.loadUrl(myUrl + "/swurent_info"); // 접속 URL
        mWebView_info.setWebChromeClient(new WebChromeClient());
        mWebView_info.setWebViewClient(new WebViewClientClass());
        mWebView_info.getSettings().setLoadWithOverviewMode(true);
        mWebView_info.getSettings().setUseWideViewPort(true);

        info_com.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info.this, compare_building.class);
                startActivity(intent);
            }
        });

        info_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView_info.canGoBack()) {
            mWebView_info.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
