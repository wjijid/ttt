package com.example.dell.yikezhong3.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;

public class ChuangzuoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView cz_back;
    private ImageView cz_duanzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuangzuo);

        cz_back = findViewById(R.id.chuangzuo_back);
        cz_back.setOnClickListener(this);
        cz_duanzi = findViewById(R.id.cz_duanzi);
        cz_duanzi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chuangzuo_back:
                finish();
                break;
            case R.id.cz_duanzi:
                Intent intent = new Intent(ChuangzuoActivity.this,WriteActivity.class);
                startActivity(intent);
                //ChuangzuoActivity.this.finish();
        }
    }
}
