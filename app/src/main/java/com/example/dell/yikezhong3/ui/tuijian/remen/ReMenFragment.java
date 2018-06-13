package com.example.dell.yikezhong3.ui.tuijian.remen;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseFragment;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.tuijian.remen.adapter.ReMenAdapter;
import com.example.dell.yikezhong3.ui.tuijian.remen.contract.RemenContract;
import com.example.dell.yikezhong3.ui.tuijian.remen.presenter.RemenPresenter;
import com.example.dell.yikezhong3.ui.xiangqing.XiangQingActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;


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
    public void showLoading() {

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
    public void dimissLoading() {


    }
    @Override
    public void getAdSuccess(AdBean adBean) {


        if (adapter != null){
            adapter.addData(adBean.getData());
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        //结束轮播

    }




}
