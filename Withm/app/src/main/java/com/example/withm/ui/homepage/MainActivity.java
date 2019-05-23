package com.example.withm.ui.homepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.withm.R;
import com.example.withm.ui.fragment.ConcernFragment;
import com.example.withm.ui.fragment.DiscoverFragment;
import com.example.withm.ui.fragment.MyFragment;
import com.example.withm.ui.fragment.WanFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout mFlContern;
    /**
     * 怎么玩
     */
    private RadioButton mRbWan;
    /**
     * 发现
     */
    private RadioButton mRbDiscover;
    /**
     * 关注
     */
    private RadioButton mRbConcern;
    /**
     * 我的
     */
    private RadioButton mRbMy;
    private RadioGroup mRg;
    private ArrayList<Fragment> mFragments;
    public static final int TYPE_WAN = 0;
    private static final int TYPE_DESCOVER = 1;
    private static final int TYPE_CONCERN = 2;
    private static final int TYPE_MY = 3;
    private FragmentManager mFragmentManager;
    private int lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        initView();
        initFragments();
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new WanFragment());
        mFragments.add(new DiscoverFragment());
        mFragments.add(new ConcernFragment());
        mFragments.add(new MyFragment());

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fl_contern, mFragments.get(0));
        transaction.commit();

    }

    private void initView() {
        mFlContern = (FrameLayout) findViewById(R.id.fl_contern);
        mRbWan = (RadioButton) findViewById(R.id.rb_wan);
        mRbDiscover = (RadioButton) findViewById(R.id.rb_discover);
        mRbConcern = (RadioButton) findViewById(R.id.rb_concern);
        mRbMy = (RadioButton) findViewById(R.id.rb_my);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mRbWan.setOnClickListener(this);
        mRbDiscover.setOnClickListener(this);
        mRbConcern.setOnClickListener(this);
        mRbMy.setOnClickListener(this);

        mRbWan.setChecked(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rb_wan:
                switchFragment(TYPE_WAN);
                break;
            case R.id.rb_discover:
                switchFragment(TYPE_DESCOVER);
                break;
            case R.id.rb_concern:
                switchFragment(TYPE_CONCERN);
                break;
            case R.id.rb_my:
                switchFragment(TYPE_MY);
                break;
        }
    }

    private void switchFragment(int type) {
        Fragment fragment = mFragments.get(type);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        Fragment hideFragment = mFragments.get(lastFragment);
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl_contern, fragment);
        }
        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();
        lastFragment = type;

    }
}
