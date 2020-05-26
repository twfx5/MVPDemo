package com.wzh.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MVC例子，缺点
 * 1。相同的代码，在不同的地方可能出现多次
 * 2.代码杂糅到一起，不好维护
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        getData();
    }

    private void getData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        String url = "https://www.baidu.com";
        final Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG", "onResponse: " + response);
                final String msg = response.message();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(msg);
                    }
                });
            }
        });
    }

}
