package com.example.withm.ui;

import android.content.Intent;

import com.example.withm.R;
import com.example.withm.base.SimpleActivity;
import com.example.withm.ui.guidepage.activity.GuidepageActivity;

public class StartActivity extends SimpleActivity {

    private int a = 3;

    @Override
    protected int createLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        super.initView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a != 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a--;
                    if (a == 0){
                        startActivity(new Intent(StartActivity.this,GuidepageActivity.class));
                        finish();
                    }
                }
            }
        }).start();
    }
}
