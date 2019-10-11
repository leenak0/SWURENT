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

public class compare extends AppCompatActivity {

    WebView mWebView_compare;
    String myUrl = "http://114.70.37.15"; // 접속 URL (내장HTML의 경우 왼쪽과 같이 쓰고 아니면 걍 URL)
    Button com_ok;
    Button com_prev;
    ImageView img_com1, img_com2;
    TextView txt_b_com1, txt_f_com1, txt_c_com1, txt_b_com2, txt_f_com2, txt_c_com2;
    String info_building, info_classroom, sen1, com_building, com_classroom, sen2;
    int info_floor, com_floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        com_ok = (Button)findViewById(R.id.com_ok);
        com_prev = (Button)findViewById(R.id.com_prev);
        img_com1=(ImageView)findViewById(R.id.img_com1);
        img_com2=(ImageView)findViewById(R.id.img_com2);
        txt_b_com1=(TextView)findViewById(R.id.txt_b_com1);
        txt_f_com1=(TextView)findViewById(R.id.txt_f_com1);
        txt_c_com1=(TextView)findViewById(R.id.txt_c_com1);
        txt_b_com2=(TextView)findViewById(R.id.txt_b_com2);
        txt_f_com2=(TextView)findViewById(R.id.txt_f_com2);
        txt_c_com2=(TextView)findViewById(R.id.txt_c_com2);

        Intent intent = getIntent();
        info_building = intent.getStringExtra("info_building");
        info_floor = intent.getIntExtra("info_floor",0);
        info_classroom = intent.getStringExtra("info_classroom");
        sen1 = intent.getStringExtra("sen1");
        com_building = intent.getStringExtra("com_building");
        com_floor = intent.getIntExtra("com_floor",0);
        com_classroom = intent.getStringExtra("com_classroom");
        sen2 = intent.getStringExtra("sen2");

        txt_b_com1.setText(info_building);
        txt_f_com1.setText(info_floor+"층");
        txt_c_com1.setText(info_classroom);
        txt_b_com2.setText(com_building);
        txt_f_com2.setText(com_floor+"층");
        txt_c_com2.setText(com_classroom);

        if(sen1=="b1")
            img_com1.setImageResource(R.drawable.classroom1);
        else if(sen1=="b2")
            img_com1.setImageResource(R.drawable.classroom2);
        else if(sen1=="b3")
            img_com1.setImageResource(R.drawable.classroom3);

        if(sen1=="b1")
            img_com2.setImageResource(R.drawable.classroom1);
        else if(sen1=="b2")
            img_com2.setImageResource(R.drawable.classroom2);
        else if(sen1=="b3")
            img_com2.setImageResource(R.drawable.classroom3);

        // 웹뷰 셋팅
        mWebView_compare = (WebView)findViewById(R.id.webView_compare);
        mWebView_compare.getSettings().setJavaScriptEnabled(true);

        mWebView_compare.loadUrl(myUrl + "/swurent_compare_"+sen1+"_"+sen2); // 접속 URL
        mWebView_compare.setWebChromeClient(new WebChromeClient());
        mWebView_compare.setWebViewClient(new WebViewClientClass());
        mWebView_compare.getSettings().setLoadWithOverviewMode(true);
        mWebView_compare.getSettings().setUseWideViewPort(true);

        com_ok.setOnClickListener(new View.OnClickListener(){ //메인메뉴로

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
