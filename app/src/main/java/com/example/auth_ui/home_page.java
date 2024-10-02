package com.example.auth_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.util.Log;

public class home_page extends AppCompatActivity {
    TextView name;
    WebView portfolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        portfolio = findViewById(R.id.portfolio);
        name = findViewById(R.id.name);
        String username = getIntent().getStringExtra("username");
        name.setText("Welcome Back " + username);

        // Enable JavaScript
        WebSettings webSettings = portfolio.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set WebViewClient to open URLs inside the WebView
        portfolio.setWebViewClient(new WebViewClient());

        // Log to check if the WebView is loading
        Log.d("WebView", "Loading URL: https://www.farehahassan.com/");

        // Load your website
        portfolio.loadUrl("https://www.farehahassan.com/");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reload the WebView
        portfolio.reload();
    }
}
