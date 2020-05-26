package com.wzh.mvpdemo3.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 所有Activity的基类，有泛型<p>所有Presenter的基类
 *
 * BaseActivity里面是所有Activity都有的方法
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        mPresenter = createPresenter(); //每个Activity的Presenter都不一样，所以交给子类实现
        mPresenter.attach(this);
        initView();
        initData();
    }

    protected abstract P createPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setContentView();

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
