package com.example.withm.http.presenter;

import android.content.Context;
import android.util.Log;

import com.example.withm.R;
import com.example.withm.app.MyApplication;
import com.example.withm.base.BasePresenter;
import com.example.withm.constant.Constants;
import com.example.withm.http.bean.RegisterBean;
import com.example.withm.http.bean.SinaBean;
import com.example.withm.http.bean.UserBean;
import com.example.withm.http.bean.VerifyBean;
import com.example.withm.http.callback.ResultCallBack;
import com.example.withm.http.model.SinaModel;
import com.example.withm.http.model.VerifyModel;
import com.example.withm.http.view.SinaView;
import com.example.withm.ui.StartActivity;
import com.example.withm.ui.login.LoginActivity;
import com.example.withm.utils.DaoUtil;
import com.example.withm.utils.Logger;
import com.example.withm.utils.SpUtil;
import com.example.withm.utils.ToastUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 张嘉河 on 2019/5/23.
 */

public class SinaPresenter extends BasePresenter<SinaView> {

    private static final String TAG = "SinaPresenter";
    private SinaModel mModel;
    private VerifyModel mVerifyModel;

    @Override
    protected void initModel() {
        mVerifyModel = new VerifyModel();
        mModel = new SinaModel();
        mBaseModels.add(mModel);
    }

    public void loginSina(String uid) {
        mModel.loginSina(uid, new ResultCallBack<SinaBean>() {
            @Override
            public void onSuccess(SinaBean bean) {
                saveUserInfo(bean.getResult());
                if (bean.getResult() != null) {
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
        //将用户信息存到数据库
        UserBean userBean = new UserBean(null, result.getUid(), result.getUserName(),
                result.getPhone(), result.getPhoto(), result.getGender(), "追梦",
                true);
        DaoUtil.getBaseUtil().insert(userBean);
        //我的页面去查询数据库设置信息
        List query = DaoUtil.getBaseUtil().query();
        Log.d(TAG, "查询: " + query.toString());
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

    public void downVerifyCode() {
        mVerifyModel.downVerifyCode(new ResultCallBack<VerifyBean>() {
            @Override
            public void onSuccess(VerifyBean bean) {
                mView.onSuccessVerify(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.onFailVerify(msg);
            }
        });
    }

    public void register(String name, String psd, String phone, String verify) {
        mVerifyModel.register(name, psd, phone, verify, new ResultCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean bean) {
                if (mView != null) {
                    mView.onSuccessRegister(bean);
                }
            }

            @Override
            public void onFail(String msg) {
                if (mView != null) {
                    mView.onFailRegister(msg);
                }
            }
        });
    }
}
