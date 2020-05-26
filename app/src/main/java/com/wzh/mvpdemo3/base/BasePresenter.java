package com.wzh.mvpdemo3.base;


/**
 * 每个Presenter中持有的View都不一样，所以使用泛型V
 *
 * BasePresenter里面是每个Presenter都有的方法attach、detach
 */
public class BasePresenter<V extends BaseView> {

    private V mView;

    public void attach(V view) {
        this.mView = view;
    }

    // 界面退出时mView也置空
    public void detach() {
        this.mView = null;
    }

    public V getView() {
        return mView;
    }
}
