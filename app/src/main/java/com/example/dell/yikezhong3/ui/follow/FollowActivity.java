package com.example.dell.yikezhong3.ui.follow;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.bean.FllowBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.follow.adapter.FollowAdapter;
import com.example.dell.yikezhong3.ui.follow.contract.FollowContract;
import com.example.dell.yikezhong3.ui.follow.presenter.FollowPresenter;
import com.example.dell.yikezhong3.ui.login.contract.LoginContract;
import com.example.dell.yikezhong3.ui.regin.contract.RegisterContract;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.adapter.AttentionAdapter;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract.AttentionContract;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.presenter.AttentionPresenter;

import java.util.ArrayList;
import java.util.List;

public class FollowActivity extends BaseActivity<AttentionPresenter> implements AttentionContract.View {

    private RecyclerView  recyclerView;
    private FollowAdapter adapter;
    private TextView foll_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();


    }

    private void initview() {


        foll_text=findViewById(R.id.foll_text);
        foll_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        recyclerView=findViewById(R.id.fmRv);
        List<AttentionBean.DataBean> list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new FollowAdapter(this,list);
        recyclerView.setAdapter(adapter);

        initData();
    }
    private void initData() {
        mPresenter.getAttention("14445","DEEDFF540856EC880DC7EB2F8C16C7E5");

    }
    @Override
    public int getContentLayout() {
        return R.layout.activity_follow;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpMoudle(new HttpMoudle())
                .build()
                .inject(this);
    }



    @Override
    public void getAttentionSuccess(AttentionBean attentionBean) {
        if (adapter != null){
            adapter.addData(attentionBean.getData());

        }
    }
}
