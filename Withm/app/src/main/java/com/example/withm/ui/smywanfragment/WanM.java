package com.example.withm.ui.smywanfragment;

import com.example.withm.base.BaseObserver;
import com.example.withm.http.callback.ResultCallBack;
import com.example.withm.utils.HttpUtils;
import com.example.withm.utils.RxUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Dell on 2019/5/22.
 */

public class WanM {
    public void GetData(final ResultCallBack<DayBean> resultCallBack) {
      HttpUtils.getInstance().getApiserver(MyServer.DAILY,MyServer.class)
              .daydata()
              .compose(RxUtils.<DayBean>rxObserableSchedulerHelper())
              .subscribe(new BaseObserver<DayBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(DayBean dayBean) {
                    resultCallBack.onSuccess(dayBean);
                  }
              });

    }
}
