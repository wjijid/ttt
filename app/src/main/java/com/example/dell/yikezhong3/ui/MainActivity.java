package com.example.dell.yikezhong3.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.activity.LoginActivity;
import com.example.dell.yikezhong3.ui.duanzi.DuanziFragment;
import com.example.dell.yikezhong3.ui.tuijian.TuijianFragment;
import com.facebook.drawee.view.SimpleDraweeView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager manager;
    private FrameLayout frameLayout;
    private RadioGroup radio;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SimpleDraweeView menu;
    private ImageView person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
        View headerView = navigationView.getHeaderView(0);//获取头布局
        menu.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //item.setChecked(true);
                Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
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
        drawerLayout = findViewById(R.id.draw);
        navigationView =findViewById(R.id.nav);
        menu = findViewById(R.id.images);
        person = findViewById(R.id.person);
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.images://点击菜单，跳出侧滑菜单
                if (drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }else{
                    drawerLayout.openDrawer(navigationView);
                }
                break;
        }
    }

    private void initWindow() {//初始化窗口属性，让状态栏和导航栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int statusColor = Color.parseColor("#1976d2");
        }
    }
}
