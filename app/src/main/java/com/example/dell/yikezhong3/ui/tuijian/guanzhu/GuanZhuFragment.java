package com.example.dell.yikezhong3.ui.tuijian.guanzhu;

import android.content.Intent;
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
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.adapter.AttentionAdapter;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract.AttentionContract;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.presenter.AttentionPresenter;
import com.example.dell.yikezhong3.ui.tuijian.remen.adapter.ReMenAdapter;
import com.example.dell.yikezhong3.ui.tuijian.remen.contract.RemenContract;
import com.example.dell.yikezhong3.ui.tuijian.remen.presenter.RemenPresenter;
import com.example.dell.yikezhong3.ui.xiangqing.XiangQingActivity;

import java.util.ArrayList;
import java.util.List;

public class GuanZhuFragment  extends BaseFragment<AttentionPresenter> implements AttentionContract.View{

    private RecyclerView recv;
    private AttentionAdapter adapter;


    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.tguanzhu;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpMoudle(new HttpMoudle())
                .build()
                .inject(this);
    }



    @Override
    public void initView(View view) {
        recv=view.findViewById(R.id.recv_att);
        List<AttentionBean.DataBean> list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recv.setLayoutManager(manager);
        recv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapter = new AttentionAdapter(getActivity(),list);
        recv.setAdapter(adapter);

        initData();

    }
    private void initData() {
        mPresenter.getAttention("14445","DEEDFF540856EC880DC7EB2F8C16C7E5");

    }
    @Override
    public void getAttentionSuccess(AttentionBean attentionBean) {
        if (adapter != null){
            adapter.addData(attentionBean.getData());

        }
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), XiangQingActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
    }




}
