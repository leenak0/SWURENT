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

public class compare extends AppCompatActivity {

    WebView mWebView_compare;
    String myUrl = "http://114.70.37.15"; // 접속 URL (내장HTML의 경우 왼쪽과 같이 쓰고 아니면 걍 URL)
    Button com_ok;
    Button com_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        // 웹뷰 셋팅
        mWebView_compare = (WebView)findViewById(R.id.webView_compare);
        mWebView_compare.getSettings().setJavaScriptEnabled(true);

        mWebView_compare.loadUrl(myUrl + "/swurent_compare"); // 접속 URL
        mWebView_compare.setWebChromeClient(new WebChromeClient());
        mWebView_compare.setWebViewClient(new WebViewClientClass());
        mWebView_compare.getSettings().setLoadWithOverviewMode(true);
        mWebView_compare.getSettings().setUseWideViewPort(true);

        com_ok = (Button)findViewById(R.id.com_ok);
        com_prev = (Button)findViewById(R.id.com_prev);

        com_ok.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(compare.this, MainActivity.class);
                startActivity(intent);
            }
        });

        com_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView_compare.canGoBack()) {
            mWebView_compare.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
