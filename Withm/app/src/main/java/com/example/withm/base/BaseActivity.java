package com.example.withm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张嘉河 on 2019/5/21.
 * 有Mvp的基类
 */

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter> extends AppCompatActivity implements BaseView{

    private Unbinder mUnbinder;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createLayout());
        mUnbinder = ButterKnife.bind(this);
        mPresenter = createPresenter();
        if (mPresenter != null){
            mPresenter.attachView((V) this);
        }

        initView();
        initListener();
        initData();
    }

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected abstract P createPresenter();

    protected abstract int createLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=null){
            mUnbinder.unbind();
        }
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
