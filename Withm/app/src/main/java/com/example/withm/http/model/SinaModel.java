package com.example.withm.http.model;

import com.example.withm.base.BaseModel;
import com.example.withm.base.BaseObserver;
import com.example.withm.http.api.ApiServer;
import com.example.withm.http.api.EveryWhereService;
import com.example.withm.http.bean.SinaBean;
import com.example.withm.http.callback.ResultCallBack;
import com.example.withm.utils.HttpUtils;
import com.example.withm.utils.RxUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public class SinaModel extends BaseModel {
    public void loginSina(String uid, final ResultCallBack<SinaBean> callBack) {
        HttpUtils.getInstance().getApiserver(ApiServer.mBaseUrl,ApiServer.class)
                .postWeiboLogin(uid)
                .compose(RxUtils.<SinaBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SinaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SinaBean sinaBean) {
                        if (sinaBean != null){
                            if (sinaBean.getCode() == EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(sinaBean);
                            }else {
                                callBack.onFail(sinaBean.getDesc());
                            }
                        }
                    }
                });
    }
}
