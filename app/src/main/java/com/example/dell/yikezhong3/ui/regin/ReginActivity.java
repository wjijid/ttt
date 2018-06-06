package com.example.dell.yikezhong3.ui.regin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.RegisterBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.login.ItActivity;
import com.example.dell.yikezhong3.ui.regin.contract.RegisterContract;
import com.example.dell.yikezhong3.ui.regin.presenter.RegisterPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

public class ReginActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View,View.OnClickListener {

    private TextView regin_text;
    private Button regin;
    private EditText edit_mobile;
    private EditText edit_pass;
    private SimpleDraweeView draweeView;
    private ImageView regin_back;


    @Override
    public int getContentLayout() {
        return R.layout.activity_regin;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        //创建simpleDraweeView对象
        draweeView = findViewById(R.id.regin_sdv);
        draweeView.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login))
                .build());
        regin_text = findViewById(R.id.regin_text);
        regin_text.setOnClickListener(this);

        regin = findViewById(R.id.regin);
        regin.setOnClickListener(this);

        edit_mobile = findViewById(R.id.edit_mouble);
        edit_pass = findViewById(R.id.edit_pass);

        regin_back = findViewById(R.id.regin_back);
        regin_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regin_text:
                Intent intent = new Intent(ReginActivity.this,ItActivity.class);
                startActivity(intent);
                break;
            case R.id.regin:
                String mobile = edit_mobile.getText().toString();
                String password = edit_pass.getText().toString();
                mPresenter.register(mobile, password);
                break;
            case R.id.regin_back:
                Intent intent1 = new Intent(ReginActivity.this,ItActivity.class);
                startActivity(intent1);
                finish();
                break;
        }

    }



    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpMoudle(new HttpMoudle())
                .build()
                .inject(this);
    }


    @Override
    public void registerSuccess(RegisterBean registerBean) {
        Intent intent = new Intent(ReginActivity.this,ItActivity.class);
        startActivity(intent);
        ReginActivity.this.finish();
    }
}
