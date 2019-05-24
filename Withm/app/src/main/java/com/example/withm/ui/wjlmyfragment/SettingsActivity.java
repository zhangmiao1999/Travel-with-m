package com.example.withm.ui.wjlmyfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.withm.R;
import com.example.withm.utils.ToastUtil;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBack;
    /**
     * 设置
     */
    private TextView mTvTitle;
    /**
     * 关于伴米
     */
    private TextView mTvAbout;
    private RelativeLayout mAboutbanmi;
    /**
     * 清除缓存
     */
    private TextView mTvClear;
    private RelativeLayout mClear;
    /**
     * 字体大小
     */
    private TextView mTvTextsize;
    private RelativeLayout mSize;
    /**
     * 手机号
     */
    private TextView mTvTel;
    private RelativeLayout mTel;
    /**
     * 微信
     */
    private TextView mTvWechat;
    private RelativeLayout mWechat;
    /**
     * 微博
     */
    private TextView mTvXin;
    private RelativeLayout mXin;
    /**
     * 退出登录
     */
    private Button mExitlogin;
    private LinearLayout mLl;
    /**
     * 小
     */
    private TextView mTvTextsmall;
    //1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvAbout = (TextView) findViewById(R.id.tv_about);
        mAboutbanmi = (RelativeLayout) findViewById(R.id.aboutbanmi);
        mAboutbanmi.setOnClickListener(this);
        mTvClear = (TextView) findViewById(R.id.tv_clear);
        mClear = (RelativeLayout) findViewById(R.id.clear);
        mClear.setOnClickListener(this);
        mTvTextsize = (TextView) findViewById(R.id.tv_textsize);
        mSize = (RelativeLayout) findViewById(R.id.size);
        mSize.setOnClickListener(this);
        mTvTel = (TextView) findViewById(R.id.tv_tel);
        mTel = (RelativeLayout) findViewById(R.id.tel);
        mTel.setOnClickListener(this);
        mTvWechat = (TextView) findViewById(R.id.tv_wechat);
        mWechat = (RelativeLayout) findViewById(R.id.wechat);
        mWechat.setOnClickListener(this);
        mTvXin = (TextView) findViewById(R.id.tv_xin);
        mXin = (RelativeLayout) findViewById(R.id.xin);
        mXin.setOnClickListener(this);
        mExitlogin = (Button) findViewById(R.id.exitlogin);
        mExitlogin.setOnClickListener(this);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mTvTextsmall = (TextView) findViewById(R.id.tv_textsmall);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.aboutbanmi:
                startActivity(new Intent(this, AboutBMActivity.class));
                break;
            case R.id.clear:
                break;
            case R.id.size:
                popupwindow();
                break;
            case R.id.tel:
                break;
            case R.id.wechat:
                break;
            case R.id.xin:
                break;
            case R.id.exitlogin:
                break;
        }
    }

    private void popupwindow() {
        final PopupWindow popupWindow = new PopupWindow();
        View inflate = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.layout_itempop, null);
        //点击取消popupwindow
        popOnClick(popupWindow, inflate);

        popupWindow.setContentView(inflate);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.showAtLocation(mLl, 0, 0, Gravity.NO_GRAVITY);
    }

    private void popOnClick(final PopupWindow popupWindow, View inflate) {
        inflate.findViewById(R.id.small).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                mTvTextsmall.setText(R.string.small);
            }
        });
        inflate.findViewById(R.id.m).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                mTvTextsmall.setText(R.string.m);
            }
        });
        inflate.findViewById(R.id.big).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                mTvTextsmall.setText(R.string.big);
            }
        });
        inflate.findViewById(R.id.dissmis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
