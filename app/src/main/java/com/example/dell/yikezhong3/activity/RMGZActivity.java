package com.example.dell.yikezhong3.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.fragment.TabFragment;
import com.example.dell.yikezhong3.fragment.TabFragment1;
import com.example.dell.yikezhong3.fragment.TabFragment2;
import com.example.dell.yikezhong3.fragment.TabFragment3;
import com.example.dell.yikezhong3.fragment.TabFragment4;
import com.example.dell.yikezhong3.fragment.TabFragment5;

import java.util.ArrayList;

public class RMGZActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    ArrayList<String> titleList = new ArrayList<String>();
    private TextView qv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmgz);

        tabLayout = (TabLayout) findViewById(R.id.tl_tab);
        viewPager = (ViewPager) findViewById(R.id.viewpage);
        qv = findViewById(R.id.qx);
        qv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RMGZActivity.this.finish();
            }
        });
        initData();//添加数据
        //fragment管理器
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //让tablayout和Viewpager关联;
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(3).select();
    }

    private void initData() {
        for (int i = 0; i <6 ; i++) {
            fragmentList.add(new TabFragment());//对应的布局
            fragmentList.add(new TabFragment1());
            fragmentList.add(new TabFragment2());
            fragmentList.add(new TabFragment3());
            fragmentList.add(new TabFragment4());
            fragmentList.add(new TabFragment5());
        }
        titleList.add("新闻");
        titleList.add("爆笑");
        titleList.add("励志");
        titleList.add("美食");
        titleList.add("网红");
        titleList.add("颜值");
    }
    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //返回对应布局
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return titleList.size();//菜单数量
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);//返回对应菜单标题
        }
    }
}
