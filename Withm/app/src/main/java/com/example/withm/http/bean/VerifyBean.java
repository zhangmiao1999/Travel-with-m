package com.example.withm.http.bean;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public class VerifyBean {
    /**
     * code : 200
     * ret : success
     * data : icpz
     */

    private int code;
    private String ret;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
