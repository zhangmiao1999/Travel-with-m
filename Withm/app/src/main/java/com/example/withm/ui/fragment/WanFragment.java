package com.example.withm.ui.fragment;


import android.content.Intent;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.withm.R;
import com.example.withm.base.BaseFragment;
import com.example.withm.ui.smywanfragment.DayBean;
import com.example.withm.ui.smywanfragment.WanAdapter;
import com.example.withm.ui.smywanfragment.WanP;
import com.example.withm.ui.smywanfragment.WanV;
import com.example.withm.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

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

    @Override
    public void Success(final DayBean bean) {
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        List<DayBean.ResultBean.RoutesBean> itemList = bean.getResult().getRoutes();
        WanAdapter adapter = new WanAdapter(getActivity(),itemList);
          rlv.setAdapter(adapter);

//          adapter.SetOnItemClickLisener(new WanAdapter.OnItemClickLisener() {
//              @Override
//              public void OnItemClickLisener(int position) {
//                  Intent intent = new Intent(getContext(), WanDiatlyActivity.class);
//                  intent.putExtra("pic",bean.getResult().getRoutes().get(0).getCardURL());
//                  startActivity(intent);
//              }
//          });
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort("数据回来失败");
    }
}
