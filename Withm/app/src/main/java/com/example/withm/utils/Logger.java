package com.example.withm.utils;

import android.util.Log;

import com.example.withm.constant.Constants;

public class Logger {
    public static void logD(String tag,String msg){
        if (Constants.isDebug){
            Log.d(tag, "logD: "+msg);
        }
    }
}