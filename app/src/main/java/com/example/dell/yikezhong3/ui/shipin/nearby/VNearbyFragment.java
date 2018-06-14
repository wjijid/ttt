package com.example.dell.yikezhong3.ui.shipin.nearby;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseFragment;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.bean.JokesBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.gerenxq.SPXQActivity;
import com.example.dell.yikezhong3.ui.shipin.follow.VFollowAdapter;
import com.example.dell.yikezhong3.ui.shipin.follow.VFollowContract;
import com.example.dell.yikezhong3.ui.shipin.follow.VFollowPresenter;

import java.util.ArrayList;
import java.util.List;

public class VNearbyFragment extends BaseFragment<VNearbyPresenter> implements VNearbyContract.View{


    private RecyclerView recv;
    private VNearbyAdapter adapter;
    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.nearfragment;
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
        super.initView(view);
        recv=view.findViewById(R.id.recv);
        List<JokesBean.DataBean> list = new ArrayList<>();
        recv.setLayoutManager(new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        adapter = new VNearbyAdapter(getActivity(),list);
        recv.setAdapter(adapter);

        initData();
    }

    private void initData() {
        mPresenter.getJokes("23");


    }



    @Override
    public void getJokeSuccess(JokesBean jokesBean) {
        if (adapter != null){
            adapter.addData(jokesBean.getData());
        }

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(getContext(), SPXQActivity.class);
                startActivity(intent);
            }



            @Override
            public void onLongItemClick(int position) {

            }
        });
    }
}
