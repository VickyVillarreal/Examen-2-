package com.iteso.sesion13_scrollabletab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ActivityEula extends AppCompatActivity {
    protected WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula);
        mWebView = (WebView) findViewById(R.id.activity_eula_webView);
        mWebView.loadUrl("https://www.linkedin.com/legal/mobile/eula");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
