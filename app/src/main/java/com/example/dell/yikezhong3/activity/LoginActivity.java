package com.example.dell.yikezhong3.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.ui.MainActivity;
import com.example.dell.yikezhong3.ui.login.ItActivity;
import com.example.dell.yikezhong3.utlis.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private TextView login_qita;
    private ImageView login_back;
    private ImageView login_qq;

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

        login_back = findViewById(R.id.login_back);
        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });

        login_qq = findViewById(R.id.login_img2);
        login_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //授权
                UMShareAPI mShareAPI = UMShareAPI.get(LoginActivity.this);
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
            }
        });
    }
    //授权的事件
    UMAuthListener umAuthListener = new UMAuthListener() {

        private String uid;
        private String iconurl;
        private String name;

        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Log.e("onStart", "onStart"); }
        //授权成功了。map里面就封装了一些qq信息
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {


            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            uid = map.get("uid");
            String openid = map.get("openid");//微博没有
            String unionid = map.get("unionid");//微博没有
            String access_token = map.get("access_token");
            String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
            String expires_in = map.get("expires_in");
            name = map.get("name");
            String gender = map.get("gender");//性别
            //头像
            iconurl = map.get("iconurl");
            SharedPreferencesUtils.setParam(LoginActivity.this,"name",name);
            SharedPreferencesUtils.setParam(LoginActivity.this,"iconurl",iconurl);
            SharedPreferencesUtils.setParam(LoginActivity.this,"uid",uid);
            Toast.makeText(getApplicationContext(), "name=" + name + ",gender=" + gender, Toast.LENGTH_SHORT).show();
        }
        //授权失败
        @Override public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Log.e("onError", "onError");
        }

        @Override public void onCancel(SHARE_MEDIA share_media, int i) {
            Log.e("onCancel", "onCancel");
        }
    };
    //授权回调
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}

