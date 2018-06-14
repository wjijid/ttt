package com.example.dell.yikezhong3.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;

import java.util.ArrayList;
import java.util.List;

public class SheZhiActivity extends AppCompatActivity implements View.OnClickListener {

    private Button tuichudenglu;
    private TextView shezhi_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        tuichudenglu = findViewById(R.id.tuichudenglu);
        tuichudenglu.setOnClickListener(this);
        shezhi_back = findViewById(R.id.shezhi_back);

        shezhi_back.setOnClickListener(this);
        final List<String> items = new ArrayList<String>(); //设置要显示的数据，这里因为是例子，所以固定写死
        items.add("检查更新");
        items.add("意见反馈");
        items.add("关于一刻钟");
        items.add("清除缓存");

        ListView listView = (ListView) findViewById(R.id.listview); // 从布局中获取listview，也可以动态创建
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, items));//关联Adapter
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tuichudenglu:
                Intent intent = new Intent(SheZhiActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_back:
                SheZhiActivity.this.finish();
                break;
        }
    }
}
