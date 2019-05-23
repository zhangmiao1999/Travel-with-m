package com.example.withm.http.view;

import com.example.withm.base.BaseView;
import com.example.withm.http.bean.SinaBean;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public interface SinaView extends BaseView {
    void onSuccess(SinaBean bean);

    void onFail(String msg);

    void go2MainActivity();
}
