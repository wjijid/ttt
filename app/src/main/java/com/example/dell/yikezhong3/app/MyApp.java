package com.example.dell.yikezhong3.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化
        Fresco.initialize(this);
    }
}
