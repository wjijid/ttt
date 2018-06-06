package com.example.dell.yikezhong3.ui.tuijian.remen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseFragment;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.tuijian.remen.adapter.ReMenAdapter;
import com.example.dell.yikezhong3.ui.tuijian.remen.contract.RemenContract;
import com.example.dell.yikezhong3.ui.tuijian.remen.presenter.RemenPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;


import java.util.ArrayList;
import java.util.List;

public class ReMenFragment extends BaseFragment<RemenPresenter> implements RemenContract.View {


    private Banner banner;
    private RecyclerView recv;
    private ReMenAdapter adapter;


    @Override
    public int getContentLayout() {
        return R.layout.tremen;
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
        banner=view.findViewById(R.id.banner);
        inbanner();
        List<Integer> li=new ArrayList<>();


        li.add(R.drawable.ad1);
        li.add(R.drawable.ad2);
        li.add(R.drawable.ad3);
        li.add(R.drawable.ad4);


        banner.setImages(li);
        banner.start();



        recv=view.findViewById(R.id.recv_hot);
        List<AdBean.DataBean> list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recv.setLayoutManager(manager);
        recv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapter = new ReMenAdapter(getActivity(),list);
        recv.setAdapter(adapter);

        initData();
    }

    private void  inbanner(){
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new GlideImageLoader());
        banner.setDelayTime(1500);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER);
    }
    private void initData() {
        mPresenter.getAd("442A977AF5C64DF404F761900020CE70","10");

    }

    @Override
    public void getAdSuccess(AdBean adBean) {


        if (adapter != null){
            adapter.addData(adBean.getData());
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //结束轮播

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }
}
