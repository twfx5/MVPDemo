package com.wzh.mvpdemo3;

import com.wzh.mvpdemo3.base.BasePresenter;

/**
 * 解绑优化
 * 每个Presenter里面都有attach、detach代码；
 * 每个Activity里面都要掉attach、detach
 * 很多代码是重复的
 *
 * 采用模板基类和泛型解决
 *
 * UserInfoPresenter继承自BasePresenter<V>，泛型V对应具体要操作的View
 * 也就是UserInfoContract.UserInfoView，所以Contract中的View也要继承BaseView接口
 *
 * UserInfoPresenter实现UserInfoContract.UserInfoPresenter，用来处理自己特有的方法
 */
public class UserInfoPresenter extends BasePresenter<UserInfoContract.UserInfoView> implements UserInfoContract.UserInfoPresenter {

    private UserInfoContract.UserInfoModel mModel;

    public UserInfoPresenter() {
        this.mModel = new UserInfoModel();
    }

    @Override
    public void getUserInfo() {
        if (getView() != null)
            getView().onLoading();
        try {
            String msg = mModel.getUserInfo();
            // mView不是空时，才去设置
            if (getView() != null)
                getView().onSuccess(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
