package com.example.withm.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.withm.R;
import com.example.withm.base.BaseFragment;
import com.example.withm.ui.login.LoginActivity;
import com.example.withm.ui.wjlmyfragment.MyPresenter;
import com.example.withm.ui.wjlmyfragment.MyView;
import com.example.withm.ui.wjlmyfragment.SettingsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment<MyView, MyPresenter> implements MyView {
    @BindView(R.id.set)
    ImageView set;
    @BindView(R.id.message)
    ImageView message;
    @BindView(R.id.iv_my)
    ImageView ivMy;
    @BindView(R.id.tv_my)
    TextView tvMy;
    @BindView(R.id.v_my)
    View vMy;
    @BindView(R.id.iv_car)
    ImageView ivCar;
    @BindView(R.id.tv_car)
    TextView tvCar;
    @BindView(R.id.v_car)
    View vCar;
    @BindView(R.id.iv_go)
    ImageView ivGo;
    @BindView(R.id.tv_go)
    TextView tvGo;
    @BindView(R.id.v_go)
    View vGo;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.tv_love)
    TextView tvLove;
    @BindView(R.id.v_love)
    View vLove;
    @BindView(R.id.iv_concern)
    ImageView ivConcern;
    @BindView(R.id.tv_concern)
    TextView tvConcern;
    @BindView(R.id.v_concern)
    View vConcern;
    @BindView(R.id.iv_yi)
    ImageView ivYi;
    @BindView(R.id.tv_yi)
    TextView tvYi;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.unlogin)
    TextView unlogin;
    @BindView(R.id.rl_my)
    RelativeLayout rlMy;
    @BindView(R.id.rl_car)
    RelativeLayout rlCar;
    @BindView(R.id.rl_go)
    RelativeLayout rlGo;
    @BindView(R.id.rl_love)
    RelativeLayout rlLove;
    @BindView(R.id.rl_concern)
    RelativeLayout rlConcern;
    @BindView(R.id.cd_unlogin)
    CardView cdUnlogin;



    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.cd_unlogin,R.id.rl_my, R.id.rl_car, R.id.rl_go, R.id.rl_love, R.id.rl_concern,R.id.set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cd_unlogin:
                goLogin();
                break;
            case R.id.rl_my:
                break;
            case R.id.rl_car:
                break;
            case R.id.rl_go:
                break;
            case R.id.rl_love:
                break;
            case R.id.rl_concern:
                break;
            case R.id.set:
                startActivity(new Intent(getContext(), SettingsActivity.class));
                break;
        }
    }

    private void goLogin() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivityForResult(intent, 100);
    }



}
