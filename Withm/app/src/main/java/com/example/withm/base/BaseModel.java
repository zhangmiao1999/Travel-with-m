package com.example.withm.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by 张嘉河 on 2019/5/21.
 */

public class BaseModel {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void detachView() {
        mCompositeDisposable.clear();
    }
}
