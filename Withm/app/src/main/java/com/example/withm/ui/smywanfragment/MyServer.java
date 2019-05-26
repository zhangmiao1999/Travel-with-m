package com.example.withm.ui.smywanfragment;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Dell on 2019/5/23.
 */

public interface MyServer {

    //每日精选
    public static final String DAILY="http://api.banmi.com/api/3.0/";
    //    http://baobab.wandoujia.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("content/routesbundles?page=1&token=JVy0IvZamK7f7FBZLKFtoniiixKMlnnJ6dWZ6NlsY4HGsxcAA9qvFo8yacHCKHE8YAcd0UF9L59nEm7zk9AUixee0Hl8EeWA880c0ikZBW0KEYuxQy5Z9NP3BNoBi3o3Q0g")
    Observable<DayBean> daydata();
}
