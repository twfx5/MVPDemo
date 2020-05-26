package com.wzh.mvpdemo4.base;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 每个Presenter中持有的View都不一样，所以使用泛型V
 *
 * BasePresenter里面是每个Presenter都有的方法attach、detach
 */
public class BasePresenter<V extends BaseView> {

    private V mView, mProxyView;

    public void attach(final V view) {
        this.mView = view;
        // 上面这行代码注释掉，可以验证 mView == null的情况，这时程序不会崩溃，但也不会显示数据
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                // 动态代理每次都调用被代理的对象，执行这个方法
                if (mView == null) return null;
                // mView != null，表示没解绑，则执行原始被代理View的方法
                return method.invoke(mView, objects);
            }
        });
    }


    public void detach() {
        this.mView = null;
        this.mProxyView = null; // 界面退出时代理对象也置空
    }

    public V getView() {
        // 这里返回的是代理对象，不是原始对象
        return mProxyView;
    }
}
