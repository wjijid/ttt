package com.example.dell.yikezhong3.ui.shipin.follow;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseFragment;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.adapter.AttentionAdapter;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract.AttentionContract;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.presenter.AttentionPresenter;

import java.util.ArrayList;
import java.util.List;

public class VFollowFragment extends BaseFragment<VFollowPresenter> implements VFollowContract.View{

    private RecyclerView recv;
    private VFollowAdapter adapter;
    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }

    @Override
    public int getContentLayout() {
        return  R.layout.video_followfragment;
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
        recv=view.findViewById(R.id.recv);
        List<AdBean.DataBean> list = new ArrayList<>();
        recv.setLayoutManager(new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        adapter = new VFollowAdapter(getActivity(),list);
        recv.setAdapter(adapter);

        initData();

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
}
