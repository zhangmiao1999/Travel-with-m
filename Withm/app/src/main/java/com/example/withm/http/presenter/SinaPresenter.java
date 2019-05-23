package com.example.withm.http.presenter;

import android.content.Context;
import android.util.Log;

import com.example.withm.R;
import com.example.withm.app.MyApplication;
import com.example.withm.base.BasePresenter;
import com.example.withm.constant.Constants;
import com.example.withm.http.bean.SinaBean;
import com.example.withm.http.callback.ResultCallBack;
import com.example.withm.http.model.SinaModel;
import com.example.withm.http.view.SinaView;
import com.example.withm.ui.StartActivity;
import com.example.withm.ui.login.LoginActivity;
import com.example.withm.utils.Logger;
import com.example.withm.utils.SpUtil;
import com.example.withm.utils.ToastUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public class SinaPresenter extends BasePresenter<SinaView> {

    private static final String TAG = "SinaPresenter";
    private SinaModel mModel;

    @Override
    protected void initModel() {
        mModel = new SinaModel();
        mBaseModels.add(mModel);
    }

    public void loginSina(String uid) {
        mModel.loginSina(uid, new ResultCallBack<SinaBean>() {
            @Override
            public void onSuccess(SinaBean bean) {
                if (bean.getResult() != null) {
                    saveUserInfo(bean.getResult());
                    if (mView != null) {
                        ToastUtil.showShort("登录成功");
                        mView.go2MainActivity();
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                if (mView != null) {
                    ToastUtil.showShort("登录失败");
                }
            }
        });
    }

    private void saveUserInfo(SinaBean.ResultBean result) {
        SpUtil.setParam("token", result.getToken());
        SpUtil.setParam(Constants.DESC, result.getDescription());
        SpUtil.setParam(Constants.USERNAME, result.getUserName());
        SpUtil.setParam(Constants.GENDER, result.getGender());
        SpUtil.setParam(Constants.EMAIL, result.getEmail());
        SpUtil.setParam(Constants.PHOTO, result.getPhoto());
        SpUtil.setParam(Constants.PHONE, result.getPhone());
    }

    public void oauthLogin(SHARE_MEDIA sina, LoginActivity loginActivity) {
        //UMShareAPI.get(mMvpView.getAct()).deleteOauth(mMvpView.getAct(),SHARE_MEDIA.SINA,authListener);
        UMShareAPI umShareAPI = UMShareAPI.get(loginActivity);
        //media,三方平台
        //authListener,登录回调
        //每次登录拉起授权
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(loginActivity).setShareConfig(config);
        umShareAPI.getPlatformInfo(loginActivity, sina, authListener);
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data != null) {
                logMap(data);
                if (platform == SHARE_MEDIA.SINA) {
                    loginSina(data.get("uid"));
                    //登录成功 保存状态
                    SpUtil.setParam("loginBind", true);
                }
            }
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Logger.logD("onError", t.toString());
            ToastUtil.showShort("授权回调失败");
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            ToastUtil.showShort("授权取消了");
        }
    };

    private void logMap(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            Log.d(TAG, "logMap: " + entry.getKey() + "," + entry.getValue());
        }
    }
}
