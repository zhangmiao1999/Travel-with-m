package com.example.withm.http.api;

import com.example.withm.http.bean.SinaBean;
import com.example.withm.http.bean.VerifyBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public interface ApiServer {
    String mBaseUrl = "http://api.banmi.com/";

    /**
     * 微博登录
     *
     * @param oAuthToken 就是三方里面的uid
     * @return
     */
    @FormUrlEncoded
    @POST("api/3.0/account/login/oauth")
    Observable<SinaBean> postWeiboLogin(@Field("oAuthToken") String oAuthToken);

//    http://yun918.cn/study/public/index.php/
    String sLogin= "http://yun918.cn/study/public/index.php/";

    /**
     * 获取验证码
     *
     * @return
     */
    @GET("verify")
    Observable<VerifyBean> getVerifyCode();
}
