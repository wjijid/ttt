package com.example.dell.yikezhong3.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.ui.regin.ReginActivity;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.UserBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.MainActivity;
import com.example.dell.yikezhong3.ui.login.contract.LoginContract;
import com.example.dell.yikezhong3.ui.login.presenter.LoginPresenter;
import com.example.dell.yikezhong3.utlis.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ItActivity extends BaseActivity<LoginPresenter> implements LoginContract.View,View.OnClickListener {

    private TextView regin;
    private SimpleDraweeView draweeView;
    private EditText edit_zhanghao;
    private EditText edit_mima;
    private ImageView it_back;

    @Override
    public int getContentLayout() {
        return R.layout.activity_it;
    }


    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpMoudle(new HttpMoudle())
                .build()
                .inject(this);
    }

    public void login(View view) {
        //获取用户名和密码
        String mobile = edit_zhanghao.getText().toString();
        String password = edit_mima.getText().toString();
        mPresenter.login(mobile, password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        //创建simpleDraweeView对象
        draweeView =findViewById(R.id.it_sdv);
        edit_zhanghao = findViewById(R.id.edit_zhanghao);
        edit_mima = findViewById(R.id.edit_password);
        draweeView.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login))
                .build());

        regin = findViewById(R.id.regin_text);
        regin.setOnClickListener(this);
        it_back = findViewById(R.id.it_back);
        it_back.setOnClickListener(this);
    }


    @Override
    public void loginSuccess(UserBean userBean) {

        Toast.makeText(ItActivity.this, userBean.getMsg(), Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(ItActivity.this,"uid",userBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(ItActivity.this,"name",userBean.getData().getUsername() + "");
        SharedPreferencesUtils.setParam(ItActivity.this,"iconUrl",userBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(ItActivity.this,"token",userBean.getData().getToken() + "");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        ItActivity.this.finish();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regin_text:
                Intent intent = new Intent(ItActivity.this,ReginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.it_back:
                ItActivity.this.finish();
                break;
        }
    }


}
