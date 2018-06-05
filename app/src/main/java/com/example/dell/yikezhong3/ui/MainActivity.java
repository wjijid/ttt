package com.example.dell.yikezhong3.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.ui.duanzi.DuanziFragment;
import com.example.dell.yikezhong3.ui.tuijian.TuijianFragment;


public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FrameLayout frameLayout;
    private RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame,new TuijianFragment()).commit();
    }

    private void setListener() {
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn_01:
                        manager.beginTransaction().replace(R.id.frame,new TuijianFragment()).commit();
                        break;
                    case R.id.btn_02:
                        manager.beginTransaction().replace(R.id.frame,new DuanziFragment()).commit();
                        break;
                }
            }
        });
    }

    private void initView() {

        frameLayout = findViewById(R.id.frame);
        radio = findViewById(R.id.group);
    }
}
