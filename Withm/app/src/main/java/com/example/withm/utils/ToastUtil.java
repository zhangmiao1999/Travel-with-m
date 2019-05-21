package com.example.withm.utils;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.withm.R;
import com.example.withm.app.MyApplication;

/**
 * Created by 张嘉河 on 2019/5/21.
 */

public class ToastUtil {
    public static void showShort(String msg ){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(MyApplication.getInstance(),msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(MyApplication.getInstance(),msg,Toast.LENGTH_LONG).show();
    }
}
