package com.example.withm.http.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 张嘉河 on 2019/5/24.
 */
@Entity
public class UserBean {
    @Id(autoincrement = true)
    private Long id;
    @Unique
    @Property
    private int userId;
    @Property
    private String name;
    @Property
    private String phone;
    @Property
    private String headPortrait;
    @Property
    private String sex;
    @Property
    private String signature;
    @Property
    private boolean isLogin;


    @Generated(hash = 1367391023)
    public UserBean(Long id, int userId, String name, String phone,
            String headPortrait, String sex, String signature, boolean isLogin) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.headPortrait = headPortrait;
        this.sex = sex;
        this.signature = signature;
        this.isLogin = isLogin;
    }


    @Generated(hash = 1203313951)
    public UserBean() {
    }
    

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                ", isLogin=" + isLogin +
                '}';
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public int getUserId() {
        return this.userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return this.phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getHeadPortrait() {
        return this.headPortrait;
    }


    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }


    public String getSex() {
        return this.sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getSignature() {
        return this.signature;
    }


    public void setSignature(String signature) {
        this.signature = signature;
    }


    public boolean getIsLogin() {
        return this.isLogin;
    }


    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

}
