package com.android.yashika.andropedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;

import com.android.yashika.andropedia.R;

public class TutorialWebviewActivity extends AppCompatActivity {

    WebView webView;
    public String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_webview);

        Intent intent=getIntent();
        fileName = intent.getStringExtra("SUB_TUTORIAL_FILE");

        webView= (WebView) findViewById(R.id.tutorial_WebView);
        webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.TEXT_AUTOSIZING);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);
    }
}
