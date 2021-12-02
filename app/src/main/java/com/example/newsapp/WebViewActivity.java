package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

public class WebViewActivity extends AppCompatActivity {
WebView webview;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
//        toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        webview=findViewById(R.id.webview);

        Intent intnt=getIntent();
       String url= intnt.getStringExtra("Url");
       webview.setWebViewClient(new WebViewClient());
       webview.loadUrl(url);
    }
}