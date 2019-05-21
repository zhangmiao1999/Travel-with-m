package com.example.withm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张嘉河 on 2019/5/21.
 * 无Mvp的基类
 */

public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createLayout());
        mUnbinder = ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initListener() {

    }

    private void initView() {

    }

    protected abstract int createLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
