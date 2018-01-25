package com.demo.shubhamdhabhai.demoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class BaseActivity extends AppCompatActivity {

    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        container = findViewById(R.id.container);
    }

    @Override
    public void setContentView(int layoutResID) {
        getLayoutInflater().inflate(layoutResID, container);
    }
}
