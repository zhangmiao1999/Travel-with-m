package com.example.withm.http.model;

import com.example.withm.base.BaseModel;
import com.example.withm.base.BaseObserver;
import com.example.withm.http.api.ApiServer;
import com.example.withm.http.bean.RegisterBean;
import com.example.withm.http.bean.VerifyBean;
import com.example.withm.http.callback.ResultCallBack;
import com.example.withm.utils.HttpUtils;
import com.example.withm.utils.RxUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public class VerifyModel extends BaseModel {
    public void downVerifyCode(final ResultCallBack<VerifyBean> callBack) {
        HttpUtils.getInstance().getApiserver(ApiServer.sLogin,ApiServer.class)
                .getVerifyCode()
                .compose(RxUtils.<VerifyBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<VerifyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(VerifyBean verifyBean) {
                        if (verifyBean !=null){
                            if (verifyBean.getCode() == 200){
                                callBack.onSuccess(verifyBean);
                            }else {
                                callBack.onFail(verifyBean.getRet());
                            }
                        }
                    }
                });
    }

    public void register(String name, String psd, String phone, String verify, final ResultCallBack<RegisterBean> callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("username",name);
        map.put("password",psd);
        map.put("phone",phone);
        map.put("verify",verify);
        HttpUtils.getInstance().getApiserver(ApiServer.sLogin,ApiServer.class)
                .getRegister(map)
                .compose(RxUtils.<RegisterBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        if (registerBean!=null){
                            // TODO: 2019/5/23 继续实现注册加登陆
                            if (registerBean.getCode() == 200){
                                callBack.onSuccess(registerBean);
                            }else {
                                callBack.onFail(registerBean.getRet());
                            }
                        }
                    }
                });
    }
}
