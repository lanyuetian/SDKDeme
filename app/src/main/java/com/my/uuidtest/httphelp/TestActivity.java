package com.my.uuidtest.httphelp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.my.uuidtest.AnnoTest;
import com.my.uuidtest.R;

/**
 * Create by ldd
 * 日期：2022/5/5
 * 接口回调学习
 */
public class TestActivity extends AppCompatActivity {

    TextView tv_callback;

    @AnnoTest(100)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_callback = findViewById(R.id.tv_callback);

        new HttpResult().doCallBackSuc(new ICallback() {
            @Override
            public void success(String result) {
                Log.e("TAG", result);
            }

            @Override
            public void failed() {

            }
        });

    }

}