package com.example.withm.ui.xzqfragment.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 25856 on 2019/5/24.
 */

public class ConcernVpAdpter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public ConcernVpAdpter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public ConcernVpAdpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
