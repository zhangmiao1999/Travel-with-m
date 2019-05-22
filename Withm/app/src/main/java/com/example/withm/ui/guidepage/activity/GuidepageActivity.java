package com.example.withm.ui.guidepage.activity;


import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.withm.ui.homepage.MainActivity;
import com.example.withm.R;
import com.example.withm.base.SimpleActivity;
import com.example.withm.ui.guidepage.adapter.GuidancePageAdapter;
import com.example.withm.utils.SpUtil;
import com.example.withm.widget.PreviewIndicator;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by
 */

public class GuidepageActivity extends SimpleActivity implements ViewPager.OnPageChangeListener, View.OnTouchListener {

    private ViewPager mGuidanceVp;
    private PreviewIndicator mGuidePi;
    /**
     * 立即体验
     */
    private Button mGuideBtn;


    @Override
    protected int createLayout() {
        return R.layout.activity_guidepage;
    }

    @Override
    protected void initData() {
        super.initData();
        mGuidePi.initSize(80, 32, 6);
        mGuidePi.setNumbers(3);
        mGuidanceVp.addOnPageChangeListener(this);
    }

    @Override
    protected void initView() {
        boolean b = (boolean) SpUtil.getParam("guide", false);
        if (b) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        //亮色模式,会将状态栏文字修改为黑色
        StatusBarUtil.setLightMode(this);
        mGuidePi = (PreviewIndicator) findViewById(R.id.guide_pi);
        mGuidanceVp = (ViewPager) findViewById(R.id.guidance_vp);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.guide_01);
        list.add(R.drawable.guide_02);
        list.add(R.drawable.guide_03);

        GuidancePageAdapter adapter = new GuidancePageAdapter(this, list);
        mGuidanceVp.setAdapter(adapter);

        mGuideBtn = (Button) findViewById(R.id.guide_btn);
        mGuideBtn.setOnTouchListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int i) {
        mGuidePi.setSelected(i);
        if (i == 0) {
            mGuidePi.setVisibility(View.VISIBLE);
            mGuideBtn.setVisibility(View.GONE);
        } else if (i == 1) {
            mGuidePi.setVisibility(View.VISIBLE);
            mGuideBtn.setVisibility(View.GONE);
        } else if (i == 2) {
            mGuideBtn.setVisibility(View.VISIBLE);
            mGuidePi.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.guide_btn:
                Log.d("第一次点击", "onClick: ");
                SpUtil.setParam("guide", true);
                startActivity(new Intent(GuidepageActivity.this, MainActivity.class));
                finish();
                break;
        }
        return false;
    }
}
