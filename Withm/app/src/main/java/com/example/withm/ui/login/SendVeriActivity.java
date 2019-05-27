package com.example.withm.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.withm.R;
import com.example.withm.base.BaseActivity;
import com.example.withm.http.bean.RegisterBean;
import com.example.withm.http.bean.SinaBean;
import com.example.withm.http.bean.UserBean;
import com.example.withm.http.bean.VerifyBean;
import com.example.withm.http.presenter.SinaPresenter;
import com.example.withm.http.view.SinaView;

import com.example.withm.utils.ToastUtil;
import com.example.withm.widget.VerificationCodeView;
import com.umeng.socialize.media.Base;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SendVeriActivity extends BaseActivity<SinaView, SinaPresenter> implements SinaView {

    private static final String TAG = "SendVeriActivity";
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.recode)
    TextView mRecode;
    @BindView(R.id.please_in)
    TextView mPleaseIn;
    @BindView(R.id.verificationcodeview)
    VerificationCodeView verificationcodeview;

    @Override
    protected int createLayout() {
        return R.layout.activity_send_veri;
    }

    @Override
    protected SinaPresenter createPresenter() {
        return new SinaPresenter();
    }

    @Override
    protected void initView() {

        final String verify = getIntent().getStringExtra("verify");
        final String phone = getIntent().getStringExtra("phone");

        Log.d(TAG, "verify: " + verify + ",phone:" + phone);
        verificationcodeview.setOnCodeFinishListener(new VerificationCodeView.OnCodeFinishListener() {
            @Override
            public void onComplete(String content) {
                if (content.equals(verify)) {
                    mPresenter.register("小傲娇", "123456", phone, verify);
                }
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onSuccess(SinaBean bean) {

    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void go2MainActivity() {

    }

    /**
     * 获取验证码成功
     *
     * @param bean
     */
    @Override
    public void onSuccessVerify(VerifyBean bean) {

    }

    /**
     * 获取验证码失败
     *
     * @param msg
     */
    @Override
    public void onFailVerify(String msg) {

    }

    /**
     * 注册成功
     * @param bean
     */
    @Override
    public void onSuccessRegister(RegisterBean bean) {
        String data = bean.getData();
        Log.d(TAG, "123: " + data);
        if (bean != null) {
            // TODO: 2019/5/24  短路~~~~~~~~
            if (bean.getCode() == 200) {
                //去登陆之后去保存到数据库中然后去判断数据库有没有这个如果有
                //就不来到登录页面了
            }
        }
    }

    /**
     * 注册失败
     *
     * @param msg
     */
    @Override
    public void onFailRegister(String msg) {
        ToastUtil.showShort(msg);
    }

}
