package com.example.withm.ui.wjlmyfragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.withm.R;

public class AboutBMActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBack;
    /**
     * 联系客服
     */
    private TextView mTvTitle;
    /**
     * 400-086-7800
     */
    private TextView mTvPhone;
    /**
     * contact@banmi.com
     */
    private TextView mTvEmial;
    /**
     * sagyran
     */
    private TextView mTvWechat;
    private LinearLayout mLl;
    //1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_bm);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvPhone = (TextView) findViewById(R.id.tv_phone);
        mTvPhone.setOnClickListener(this);
        mTvEmial = (TextView) findViewById(R.id.tv_emial);
        mTvEmial.setOnClickListener(this);
        mTvWechat = (TextView) findViewById(R.id.tv_wechat);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mTvWechat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.tv_phone:
                call(); //打电话
                break;
            case R.id.tv_emial:
                emial();
                break;
            case R.id.tv_wechat:
                wechat();
                break;
        }
    }


    private void emial() {

    }

    private void wechat() {

    }


    @SuppressLint("MissingPermission")
    private void call() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:" + "4000867800");
        intent.setData(uri);
        startActivity(intent);
    }
}
