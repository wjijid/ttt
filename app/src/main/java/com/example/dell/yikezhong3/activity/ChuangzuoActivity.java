package com.example.dell.yikezhong3.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;

public class ChuangzuoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView cz_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuangzuo);

        cz_back = findViewById(R.id.chuangzuo_back);
        cz_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chuangzuo_back:
                finish();
                break;
        }
    }
}
