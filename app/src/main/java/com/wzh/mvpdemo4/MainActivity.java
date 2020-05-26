package com.wzh.mvpdemo4;

import android.widget.TextView;

import com.wzh.mvpdemo.R;
import com.wzh.mvpdemo4.base.BaseActivity;

/**
 * MainActivity继承自BaseActivity，也是要指明具体的Presenter
 */
public class MainActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContract.UserInfoView {

    private TextView textView;

    @Override
    protected UserInfoPresenter createPresenter() {
        return new UserInfoPresenter() ;
    }

    @Override
    protected void initData() {
        getPresenter().getUserInfo();
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.tv);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(String msg) {
        textView.setText(msg);
    }
}
