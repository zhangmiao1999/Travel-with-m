package com.example.withm.app;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by 张嘉河 on 2019/5/21.
 */

public class MyApplication extends Application {
    //腾讯bugly ID： 8136ae0c07
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        //腾讯bugly初始化
        CrashReport.initCrashReport(getApplicationContext(), "8136ae0c07", false);
    }

    public static MyApplication getInstance() {
        return sInstance;
    }
}
