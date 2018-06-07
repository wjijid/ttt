package com.example.dell.yikezhong3.ui.follow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    private void initview() {

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
        mPresenter.getAttention("1026","442A977AF5C64DF404F761900020CE70");

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
