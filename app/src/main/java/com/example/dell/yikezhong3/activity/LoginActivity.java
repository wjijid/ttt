package com.example.dell.yikezhong3.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class LoginActivity extends AppCompatActivity {

    private TextView login_qita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        //创建simpleDraweeView对象
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.login_sdv);
        draweeView.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login))
                .build());
    }

    private void initView() {
        login_qita = findViewById(R.id.login_text);
        login_qita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,ItActivity.class);
                startActivity(intent);
            }
        });
    }
}
