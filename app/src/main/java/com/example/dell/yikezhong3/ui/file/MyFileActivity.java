package com.example.dell.yikezhong3.ui.file;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.dell.yikezhong3.R;

public class MyFileActivity extends AppCompatActivity {

    private FrameLayout fr;
    private FragmentManager manager;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_file);


        fr = findViewById(R.id.fr);
        rg = findViewById(R.id.rg);

        manager = MyFileActivity.this.getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fr,new LocalFragment()).commit();


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        manager.beginTransaction().replace(R.id.fr,new LocalFragment()).commit();
                        break;
                    case R.id.rb2:
                        manager.beginTransaction().replace(R.id.fr,new UpLoadFragment()).commit();
                        break;
                }
            }
        });

    }
}
