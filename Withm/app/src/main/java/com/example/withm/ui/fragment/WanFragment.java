package com.example.withm.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.withm.R;
import com.example.withm.base.BaseFragment;
import com.example.withm.ui.smywanfragment.WanP;
import com.example.withm.ui.smywanfragment.WanV;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;

/**
 * smy
 */
public class WanFragment extends BaseFragment<WanV, WanP> implements WanV {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.smr)
    SmartRefreshLayout smr;

    @Override
    protected WanP createPresenter() {
        return new WanP();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_wan;
    }

    @Override
    protected void initData() {
        mPresenter.getData();


    }
}
