package com.example.withm.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.withm.R;
import com.example.withm.widget.VerificationCodeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SendVeriActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.recode)
    TextView mRecode;
    @BindView(R.id.please_in)
    TextView mPleaseIn;
    @BindView(R.id.verificationcodeview)
    VerificationCodeView verificationcodeview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_veri);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        verificationcodeview.setOnCodeFinishListener(new VerificationCodeView.OnCodeFinishListener() {
            @Override
            public void onComplete(String content) {
                //上来了
            }
        });
    }
}
