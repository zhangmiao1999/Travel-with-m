package com.example.withm.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.withm.R;

import java.util.ArrayList;

public class GuidepageActivity extends AppCompatActivity {

    private ViewPager mGuideVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidepage);
        initView();
    }

    private void initView() {
        mGuideVp = (ViewPager) findViewById(R.id.guide_vp);
        ArrayList<View> views = new ArrayList<>();
    }
}
