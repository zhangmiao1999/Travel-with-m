package com.example.withm.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张嘉河 on 2019/5/21.
 */

public abstract class BaseFragment<V extends BaseView,P extends BasePresenter> extends Fragment implements BaseView{
    private Unbinder mUnbinder;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(createLayout(), null);
        mUnbinder = ButterKnife.bind(this,inflate);
        mPresenter = createPresenter();
        if (mPresenter != null){
            mPresenter.attachView((V) this);
        }
        initView();
        initListener();
        initData();
        return inflate;
    }









    public void initView() {

}
