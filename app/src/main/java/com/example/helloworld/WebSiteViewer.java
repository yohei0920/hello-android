package com.example.helloworld;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.helloworld.databinding.ActivityWebSiteViewerBinding;

public class WebSiteViewer extends AppCompatActivity {

    private ActivityWebSiteViewerBinding binding;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWebSiteViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_web_site_viewer);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        progressBar = (ProgressBar) findViewById(R.id.ProgressBar);
        progressBar.setVisibility(View.INVISIBLE);

        WebView webView = (WebView) findViewById(R.id.WebSiteView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);

        binding.navView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                webView.loadUrl("https://www.google.com");
            } else if (item.getItemId() == R.id.navigation_dashboard) {
                webView.loadUrl("https://www.yahoo.com");
            } else if (item.getItemId() == R.id.navigation_notifications) {
                webView.loadUrl("https://www.bing.com");
            } else if (item.getItemId() == R.id.navigation_back) {
                webView.goBack();
            } else if (item.getItemId() == R.id.navigation_forward) {
                webView.goForward();
            }
            return true;
        });
    }

}