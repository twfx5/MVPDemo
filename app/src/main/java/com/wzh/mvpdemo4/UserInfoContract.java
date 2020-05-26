package com.wzh.mvpdemo4;

import com.wzh.mvpdemo4.base.BaseView;

/**
 * 协议类Contract（可有可无）
 * 多人协作开发时，先写好这个类，相当于搭好框架
 */
public class UserInfoContract {

    // view层
    interface UserInfoView extends BaseView {
        void onLoading();
        void onError();
        void onSuccess(String msg);
    }

    // present层
    interface UserInfoPresenter {
        void getUserInfo();
    }

    // model层
    interface UserInfoModel {
        String getUserInfo() throws Exception;
    }
}
