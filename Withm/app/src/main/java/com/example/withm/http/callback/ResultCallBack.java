package com.example.withm.http.callback;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public interface ResultCallBack<T> {
    void onSuccess(T bean);

    void onFail(String msg);
}
