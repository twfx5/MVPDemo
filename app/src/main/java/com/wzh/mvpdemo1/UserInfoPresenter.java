package com.wzh.mvpdemo1;

public class UserInfoPresenter implements UserInfoContract.UserInfoPresenter{

    // 解耦层，肯定会持有V 和 M
    private UserInfoContract.UserInfoModel mModel;
    private UserInfoContract.UserInfoView mView;

    public UserInfoPresenter(UserInfoContract.UserInfoView view) {
        this.mView = view;
        this.mModel = new UserInfoModel();
    }


    @Override
    public void getUserInfo() {
        mView.onLoading();
        try {
            String msg = mModel.getUserInfo();
            mView.onSuccess(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
