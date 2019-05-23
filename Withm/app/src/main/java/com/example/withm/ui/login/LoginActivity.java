package com.example.withm.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContentResolverCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.withm.R;
import com.example.withm.app.MyApplication;
import com.example.withm.base.BaseActivity;
import com.example.withm.base.SimpleActivity;
import com.example.withm.http.bean.SinaBean;
import com.example.withm.http.presenter.SinaPresenter;
import com.example.withm.http.view.SinaView;
import com.example.withm.ui.homepage.MainActivity;
import com.example.withm.utils.AccountValidatorUtil;
import com.example.withm.utils.SpUtil;
import com.example.withm.utils.ToastUtil;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<SinaView, SinaPresenter> implements SinaView {


    @BindView(R.id.hello)
    TextView mHello;
    @BindView(R.id.longin_banmi)
    TextView mLonginBanmi;
    @BindView(R.id.wx_login)
    TextView mWxLogin;
    @BindView(R.id.sina_login)
    TextView mSinaLogin;
    @BindView(R.id.phone_login)
    TextView mPhoneLogin;
    @BindView(R.id.casual_tv)
    TextView mCasualTv;
    @BindView(R.id.userAgreement)
    TextView mUserAgreement;
    @BindView(R.id.iv_seleced)
    ImageView mIvSeleced;
    @BindView(R.id.ed_phone)
    EditText mEdPhone;
    @BindView(R.id.sendCode_tv)
    TextView mSendCodeTv;
    @BindView(R.id.getCode_Rl)
    RelativeLayout mGetCodeRl;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.phone_ll)
    LinearLayout mPhoneLl;
    @BindView(R.id.login_ll)
    LinearLayout mLoginLl;
    //输入的手机号

    @Override
    protected int createLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        mUserAgreement.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        mUserAgreement.getPaint().setAntiAlias(true);//抗锯齿
        Boolean loginBind = (Boolean) SpUtil.getParam("loginBind", false);
        //判断是否登录，如果登录直接跳转主页
        if (loginBind) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    protected SinaPresenter createPresenter() {
        return new SinaPresenter();
    }

    @Override
    protected void initListener() {
        super.initListener();
        mEdPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    mGetCodeRl.setBackgroundResource(R.drawable.button_highlight);
                } else {
                    mGetCodeRl.setBackgroundResource(R.drawable.button_unavailable);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
    }


    @OnClick({R.id.hello, R.id.longin_banmi, R.id.wx_login, R.id.sina_login, R.id.phone_login, R.id.casual_tv, R.id.userAgreement, R.id.iv_seleced, R.id.ed_phone, R.id.sendCode_tv, R.id.getCode_Rl, R.id.view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wx_login:
                //登录微信
                ToastUtil.showShort("微信登录");
                break;
            case R.id.sina_login:
                //登录微博
                mPresenter.oauthLogin(SHARE_MEDIA.SINA, this);

                break;
            case R.id.phone_login:
                //手机号登录
                mPhoneLl.setVisibility(View.VISIBLE);
                mView.setVisibility(View.VISIBLE);
                mLoginLl.setVisibility(View.GONE);
                break;
            case R.id.casual_tv:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                //随便逛逛
                break;
            case R.id.userAgreement:
                ToastUtil.showShort("用户协议");
                //用户协议
                break;
            case R.id.iv_seleced:
                //跳一个选择国家的页面
                break;
            case R.id.ed_phone:
                //输入手机号
                break;
            case R.id.sendCode_tv:
                String phone = mEdPhone.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    ToastUtil.showShort("请输入手机号");
                    return;
                } else {
                    if (!phone.matches(AccountValidatorUtil.REGEX_MOBILE)){
                        ToastUtil.showShort("请输入正确的手机号");
                    }else {
                        startActivity(new Intent(LoginActivity.this, SendVeriActivity.class));
                        ToastUtil.showShort("验证码已发送，请注意查收!");
                    }
                }
                break;
            case R.id.getCode_Rl:

                break;
            case R.id.view:
                break;
        }
    }

    private void sinaLogin() {

    }

    /**
     * 回退监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断是否退出
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();
        }
        return false;
    }

    //Boolean类型的值
    private static Boolean isExit = false;

    private void exitBy2Click() {
        if (mPhoneLl.getVisibility() == View.VISIBLE) {
            isExit = true;
            mPhoneLl.setVisibility(View.GONE);
            mView.setVisibility(View.GONE);
            mLoginLl.setVisibility(View.VISIBLE);
        } else {
            finish();
            System.exit(0);
        }
    }


    @Override
    public void onSuccess(SinaBean bean) {

    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void go2MainActivity() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
