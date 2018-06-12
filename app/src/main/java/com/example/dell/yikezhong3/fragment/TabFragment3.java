package com.example.dell.yikezhong3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseFragment;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.collect.adapter.CollectAdapter;
import com.example.dell.yikezhong3.ui.collect.presenter.CollectPresenter;
import com.example.dell.yikezhong3.ui.follow.adapter.FollowAdapter;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract.AttentionContract;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.presenter.AttentionPresenter;

import java.util.ArrayList;
import java.util.List;

public class TabFragment3 extends BaseFragment<AttentionPresenter> implements AttentionContract.View {

    private RecyclerView recyclerView;
    private FollowAdapter adapter;
    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.tabfragment3;
    }

    @Override
    public void initView(View view) {
        super.initView(view);

        recyclerView=view.findViewById(R.id.fmRv);
        List<AttentionBean.DataBean> list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapter = new FollowAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        mPresenter.getAttention("14445","DEEDFF540856EC880DC7EB2F8C16C7E5");
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
