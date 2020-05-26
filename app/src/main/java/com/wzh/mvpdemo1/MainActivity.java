package com.wzh.mvpdemo1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wzh.mvpdemo.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MVP例子
 * M： model层，访问网络请求写在这里
 * V: View层，Activity、Fragment、View
 * P：控制层，解耦层
 *
 * 好处：
 * 解耦，维护性好
 * 定好协议后，可以多人开发（互相之间不用关注了）
 * 复用性强，其他地方想用，直接拷贝new Presenter层
 */
public class MainActivity extends AppCompatActivity implements UserInfoContract.UserInfoView{

    private TextView textView;
    private UserInfoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        mPresenter = new UserInfoPresenter(this);
        mPresenter.getUserInfo();
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
