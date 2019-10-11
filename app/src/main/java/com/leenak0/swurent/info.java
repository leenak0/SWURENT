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
import android.widget.ImageView;
import android.widget.TextView;

public class info extends AppCompatActivity {

    ImageView img_info;
    TextView txt_c_info;
    Button info_prev;
    //Button info_reserv;
    Button info_com;

    WebView mWebView_info;
    String myUrl = "http://114.70.37.15"; // 접속 URL (내장HTML의 경우 왼쪽과 같이 쓰고 아니면 걍 URL)

    String info_building, info_classroom, sen1;
    int info_floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info_prev = (Button)findViewById(R.id.info_prev);
        //info_reserv = (Button)findViewById(R.id.info_reserv);
        info_com=(Button)findViewById(R.id.info_com);
        img_info=(ImageView)findViewById(R.id.img_info);
        txt_c_info=(TextView)findViewById(R.id.txt_c_info);

        Intent intent = getIntent();
        info_building = intent.getStringExtra("info_building");
        info_floor = intent.getIntExtra("info_floor",0);
        info_classroom = intent.getStringExtra("info_classroom");
        sen1 = intent.getStringExtra("sen1");

        txt_c_info.setText(info_classroom+" 강의실 정보");
        if(sen1=="b1")
            img_info.setImageResource(R.drawable.classroom1);
        else if(sen1=="b2")
            img_info.setImageResource(R.drawable.classroom2);
        else if(sen1=="b3")
            img_info.setImageResource(R.drawable.classroom3);

        // 웹뷰 셋팅
        mWebView_info = (WebView)findViewById(R.id.webView_info);
        mWebView_info.getSettings().setJavaScriptEnabled(true);

        mWebView_info.loadUrl(myUrl + "/swurent_info_"+sen1); // 접속 URL
        mWebView_info.setWebChromeClient(new WebChromeClient());
        mWebView_info.setWebViewClient(new WebViewClientClass());
        mWebView_info.getSettings().setLoadWithOverviewMode(true);
        mWebView_info.getSettings().setUseWideViewPort(true);

        info_com.setOnClickListener(new View.OnClickListener(){ //비교

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info.this, compare_building.class);
                intent.putExtra("info_building", info_building);
                intent.putExtra("info_floor",info_floor);
                intent.putExtra("info_classroom", info_classroom);
                intent.putExtra("sen1",sen1);
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
