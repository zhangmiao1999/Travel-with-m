package com.example.withm.ui.smywanfragment;

import com.example.withm.base.BaseView;

/**
 * Created by Dell on 2019/5/22.
 */

public interface WanV extends BaseView{
    void Success(DayBean bean);

    void onFail(String msg);
}
