package com.wzh.mvpdemo2;

import android.view.View;

/**
 * 增加解绑
 * 防止Activity退出后，被GC回收了
 * 但是网络请求回调过来onSuccess，造成崩溃
 */
public class UserInfoPresenter implements UserInfoContract.UserInfoPresenter{

    // 解耦层，肯定会持有V 和 M
    private UserInfoContract.UserInfoModel mModel;
    private UserInfoContract.UserInfoView mView;

    public UserInfoPresenter() {
        this.mModel = new UserInfoModel();
    }

    public void attach(UserInfoContract.UserInfoView view) {
        this.mView = view;
    }

    // 界面退出时mView也置空
    public void detach() {
        this.mView = null;
    }

    @Override
    public void getUserInfo() {
        mView.onLoading();
        try {
            String msg = mModel.getUserInfo();
            // mView不是空时，才去设置
            if (mView != null)
                mView.onSuccess(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
