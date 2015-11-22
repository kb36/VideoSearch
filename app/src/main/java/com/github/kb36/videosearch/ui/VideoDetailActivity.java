package com.github.kb36.videosearch.ui;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * shows the url in a webview
 */
public class VideoDetailActivity extends Activity {
    private static final String uriPrefix = "https://player.vimeo.com/video/";
    private WebView mWv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWv = new WebView(this);
        setContentView(mWv);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        String id = getIntent().getStringExtra("id");
        mWv.getSettings().setJavaScriptEnabled(true);
        mWv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        mWv.loadUrl(uriPrefix+id);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWv.onPause();
        mWv.pauseTimers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWv.onResume();
        mWv.resumeTimers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWv.loadUrl("about:blank");
        mWv.stopLoading();
        mWv.setWebViewClient(null);
        mWv.destroy();
        mWv = null;
    }
}
