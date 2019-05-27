package com.example.withm.ui.xzqfragment.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.withm.R;
import com.example.withm.ui.xzqfragment.adpter.ConcernVpAdpter;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {

    private ImageView back;
    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initView();
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tab.addTab(tab.newTab().setText("通知"));
        tab.addTab(tab.newTab().setText("消息"));
        ArrayList<Fragment> fragments = new ArrayList<>();
        ConcernVpAdpter concernVpAdpter = new ConcernVpAdpter(getSupportFragmentManager(), fragments);
        vp.setAdapter(concernVpAdpter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
