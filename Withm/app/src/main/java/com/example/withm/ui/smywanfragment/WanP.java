package com.example.withm.ui.smywanfragment;

import com.example.withm.base.BasePresenter;
import com.example.withm.base.BaseView;
import com.example.withm.http.callback.ResultCallBack;

/**
 * Created by Dell on 2019/5/22.
 */

public class WanP extends BasePresenter<WanV> implements BaseView {

    private WanM wanM;

    @Override
    protected void initModel() {
        wanM = new WanM();
    }

    public void getData() {
        wanM.GetData(new ResultCallBack<DayBean>() {
            @Override
            public void onSuccess(DayBean bean) {
                mView.Success(bean);
            }

            @Override
            public void onFail(String msg) {
            mView.onFail(msg);
            }
        });
    }

}
