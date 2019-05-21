package com.example.withm.base;

import java.util.ArrayList;

/**
 * Created by 张嘉河 on 2019/5/21.
 */

public abstract class BasePresenter<V extends BaseView> {
    protected V mView;
    protected ArrayList<BaseModel> mBaseModels = new ArrayList<>();

    public void attachView(V view) {

        mView = view;
    }

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void detachView() {
        mView = null;
        if (mBaseModels!=null){
            for (BaseModel baseModel : mBaseModels) {
                baseModel.detachView();
            }
        }
    }
}
