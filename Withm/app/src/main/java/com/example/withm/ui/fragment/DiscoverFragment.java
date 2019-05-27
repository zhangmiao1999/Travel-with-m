package com.example.withm.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.example.withm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment{
    //Ur0F67EZ2eF4I97sgW6iIkIsE27f7Yml appkey
    private MapView mMapView = null;
    private View view;
    private MapView mBmapView;
    private BaiduMap mBaiduMap;

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_discover, null);
        initView(inflate);

        //获取地图控件引用
        mMapView = (MapView) inflate.findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        return inflate;
    }


    private void initView(View inflate) {
        mBmapView = (MapView) inflate.findViewById(R.id.bmapView);
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

}
