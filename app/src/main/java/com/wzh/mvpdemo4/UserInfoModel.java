package com.wzh.mvpdemo4;


public class UserInfoModel implements UserInfoContract.UserInfoModel {

    @Override
    public String getUserInfo() throws Exception {
        Thread.sleep(2000);
        return "14726932514";
    }

}
