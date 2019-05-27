package com.example.withm.ui.fragment;


import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.withm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment implements View.OnClickListener {
    //Ur0F67EZ2eF4I97sgW6iIkIsE27f7Yml appkey
    private MapView mMapView = null;
    private View view;
    private MapView mBmapView;
    private BaiduMap mBaiduMap;
    /**
     * 东京
     */
    private TextView mToolbarName;
    private TabLayout mTabId;
    private LocationClient mLocationClient;
    /**
     * 我在哪
     */
    private Button mBt1;
    private LatLng mLatLng;

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_discover, null);
        //获取动态权限
        initPer();
        //获取地图控件引用
        mMapView = (MapView) inflate.findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        //定位
        location();

        initView(inflate);
        return inflate;
    }

    private void location() {
        mBaiduMap.setMyLocationEnabled(true);

        //定位初始化
        mLocationClient = new LocationClient(getContext());

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

//设置locationClientOption
        mLocationClient.setLocOption(option);

//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
//开启地图定位图层
        mLocationClient.start();

    }

    private void initPer() {
        String[] per = {
                Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        ActivityCompat.requestPermissions(getActivity(), per, 100);
    }

    private void initView(View inflate) {
        mBmapView = (MapView) inflate.findViewById(R.id.bmapView);
        mToolbarName = (TextView) inflate.findViewById(R.id.toolbar_name);
        mTabId = (TabLayout) inflate.findViewById(R.id.tab_id);

        mTabId.addTab(mTabId.newTab().setText("全部"));
        mTabId.addTab(mTabId.newTab().setText("倔强的味道"));
        mTabId.addTab(mTabId.newTab().setText("猎奇另类"));
        mTabId.addTab(mTabId.newTab().setText("idol足迹"));
        mTabId.addTab(mTabId.newTab().setText("生活美学"));
        mTabId.addTab(mTabId.newTab().setText("甩掉修片"));
        mTabId.addTab(mTabId.newTab().setText("撩妹撩汉"));
        mTabId.addTab(mTabId.newTab().setText("未了生活"));
        mTabId.addTab(mTabId.newTab().setText("打破次元壁"));
        mTabId.addTab(mTabId.newTab().setText("古事印记"));
        mTabId.addTab(mTabId.newTab().setText("剁手拜金"));
        mTabId.addTab(mTabId.newTab().setText("鬼才设计"));
        mTabId.addTab(mTabId.newTab().setText("辣妈奶爸"));
        mTabId.addTab(mTabId.newTab().setText("人文宝库"));
        mTabId.addTab(mTabId.newTab().setText("大师风范"));
        mTabId.addTab(mTabId.newTab().setText("惬意时光"));
        mTabId.addTab(mTabId.newTab().setText("高颜值美食"));
        mTabId.addTab(mTabId.newTab().setText("奇妙体验"));

        mTabId.setSelectedTabIndicatorHeight(0);
        mBt1 = (Button) inflate.findViewById(R.id.bt_1);
        mBt1.setOnClickListener(this);
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
        //不加耗电
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_1:
                location2();
                break;
        }
    }

    private void location2() {
        if (mLatLng!=null){
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.zoom(16.0f);
            builder.target(mLatLng);
            MapStatusUpdate status = MapStatusUpdateFactory.newMapStatus(builder.build());
            mBaiduMap.setMapStatus(status);
        }
    }


    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    //location.getLatitude()  纬度
                    //location.getLongitude() 经度
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mLatLng = new LatLng(location.getLatitude(), location.getLongitude());
            mBaiduMap.setMyLocationData(locData);
        }
    }


}
