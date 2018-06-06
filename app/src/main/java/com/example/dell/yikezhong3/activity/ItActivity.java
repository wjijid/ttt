package com.example.dell.yikezhong3.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.yikezhong3.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class ItActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);

        //创建simpleDraweeView对象
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.it_sdv);
        draweeView.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login))
                .build());
    }
}
