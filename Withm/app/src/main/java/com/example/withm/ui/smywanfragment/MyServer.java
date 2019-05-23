package com.example.withm.ui.smywanfragment;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Dell on 2019/5/23.
 */

public interface MyServer {

    //每日精选
    public static final String DAILY="http://baobab.wandoujia.com/api/v2/";
    //    http://baobab.wandoujia.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    Observable<DayBean> daydata();
}
