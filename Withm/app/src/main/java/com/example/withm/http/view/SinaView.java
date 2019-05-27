package com.example.withm.http.view;

import com.example.withm.base.BaseView;
import com.example.withm.http.bean.RegisterBean;
import com.example.withm.http.bean.SinaBean;
import com.example.withm.http.bean.VerifyBean;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public interface SinaView extends BaseView {
    void onSuccess(SinaBean bean);

    void onFail(String msg);

    void go2MainActivity();

    void onSuccessVerify(VerifyBean bean);

    void onFailVerify(String msg);

    void onSuccessRegister(RegisterBean bean);

    void onFailRegister(String msg);
}
