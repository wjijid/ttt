package com.example.dell.yikezhong3.ui.collect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.collect.adapter.CollectAdapter;
import com.example.dell.yikezhong3.ui.collect.contract.CollectContract;
import com.example.dell.yikezhong3.ui.collect.presenter.CollectPresenter;
import com.example.dell.yikezhong3.ui.follow.adapter.FollowAdapter;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract.AttentionContract;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.presenter.AttentionPresenter;

import java.util.ArrayList;
import java.util.List;

public class MyShouCangActivity extends BaseActivity<CollectPresenter> implements CollectContract.View  {


    private RecyclerView recyclerView;
    private CollectAdapter adapter;
    private TextView foll_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }



    private void initview() {


        recyclerView=findViewById(R.id.recy_collect);
        List<CollectionBean.DataBean> list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CollectAdapter(this,list);
        recyclerView.setAdapter(adapter);

        initData();
    }
    private void initData() {
        mPresenter.getCollect("1026","442A977AF5C64DF404F761900020CE70");

    }
    @Override
    public int getContentLayout() {
        return R.layout.activity_my_shou_cang;
    }


    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpMoudle(new HttpMoudle())
                .build()
               .inject(this);
    }

    @Override
    public void getCollectSuccess(CollectionBean collectionBean) {
        if (adapter != null){
            adapter.addData(collectionBean.getData());

        }
    }
}
