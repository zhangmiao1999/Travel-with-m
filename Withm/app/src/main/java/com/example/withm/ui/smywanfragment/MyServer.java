package com.example.withm.ui.smywanfragment;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Dell on 2019/5/23.
 */

public interface MyServer {

    //每日精选
    public static final String DAILY="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    //    http://baobab.wandoujia.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("20/3")
    Observable<DayBean> daydata();
}
