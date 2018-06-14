package com.example.dell.yikezhong3.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.ui.gerenxq.SPXQActivity;

public class FaBiaoActivity extends AppCompatActivity {

    private Button kankan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_biao);
        kankan = findViewById(R.id.kankan);
        kankan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaBiaoActivity.this, SPXQActivity.class);
                startActivity(intent);
            }
        });
    }
}
