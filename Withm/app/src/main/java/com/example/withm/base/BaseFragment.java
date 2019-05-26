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
<<<<<<< HEAD
    public P mPresenter;
=======
    protected P mPresenter;
>>>>>>> 4ad5aff7444890053ec354c69ade11ffb7734439

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
<<<<<<< HEAD

    public void initData() {

    }

    public void initListener() {

    }

    public void initView() {
=======
  //石明洋 此处把私有方法修改为受保护的
    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {
>>>>>>> 4ad5aff7444890053ec354c69ade11ffb7734439

    }

    protected abstract P createPresenter();

    protected abstract int createLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=null){
            mUnbinder.unbind();
        }
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
