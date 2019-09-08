package com.leenak0.swurent;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientClass extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.d("check URL",url);
        view.loadUrl(url);
        return true;
    }
}