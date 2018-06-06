package com.example.dell.yikezhong3.ui.follow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.FllowBean;
import com.example.dell.yikezhong3.ui.follow.contract.FollowContract;
import com.example.dell.yikezhong3.ui.follow.presenter.FollowPresenter;
import com.example.dell.yikezhong3.ui.login.contract.LoginContract;
import com.example.dell.yikezhong3.ui.regin.contract.RegisterContract;

public class FollowActivity extends BaseActivity<FollowPresenter> implements FollowContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    private void initview() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_follow;
    }

    @Override
    public void inject() {

    }

    @Override
    public void getFollowSuccess(FllowBean fllowBean) {

    }
}
