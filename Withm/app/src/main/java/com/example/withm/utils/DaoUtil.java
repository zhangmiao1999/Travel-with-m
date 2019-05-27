package com.example.withm.utils;

import com.example.withm.app.MyApplication;
import com.example.withm.http.bean.UserBean;
import com.example.withm.http.dao.DaoMaster;
import com.example.withm.http.dao.DaoSession;
import com.example.withm.http.dao.UserBeanDao;

import java.util.List;


public class DaoUtil {
    private static DaoUtil sBaseUtil;
    private final UserBeanDao mBeanDao;


    public DaoUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getInstance(), "user" + ".dp");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDatabase());

        DaoSession daoSession = daoMaster.newSession();

        mBeanDao = daoSession.getUserBeanDao();
    }

    public static DaoUtil getBaseUtil() {
        if (sBaseUtil == null) {
            synchronized (DaoUtil.class) {
                if (sBaseUtil == null) {
                    sBaseUtil = new DaoUtil();
                }
            }
        }
        return sBaseUtil;
    }

    public boolean has(UserBean bean) {
        List<UserBean> list = mBeanDao.queryBuilder().where(UserBeanDao.Properties.UserId.eq(bean.getUserId())).list();
        if (list.size() > 0 && list != null) {
            return true;
        }
        return false;
    }

    public long insert(UserBean bean) {
        if (!has(bean)) {
            return mBeanDao.insertOrReplace(bean);
        }
        return -1;
    }

    public boolean delete(UserBean bean) {
        if (has(bean)) {
            mBeanDao.delete(bean);
            return true;
        }
        return false;
    }

    public List query() {
        return mBeanDao.queryBuilder().list();
    }

}
