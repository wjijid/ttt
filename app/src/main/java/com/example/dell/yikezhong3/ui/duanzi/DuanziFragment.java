package com.example.dell.yikezhong3.ui.duanzi;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseFragment;
import com.example.dell.yikezhong3.bean.JokesBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.duanzi.adapter.DuanziAdapter;
import com.example.dell.yikezhong3.ui.duanzi.contract.DuanziContract;
import com.example.dell.yikezhong3.ui.duanzi.presenter.DuanziPresenter;
import com.example.dell.yikezhong3.ui.xiangqing.XiangQingActivity;

import java.util.List;

public class DuanziFragment extends BaseFragment<DuanziPresenter> implements DuanziContract.View {

    private RecyclerView mRv;

    private int page = 23;
    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.duanzi_layout;
    }

    @Override
    public void initView(View view) {
        super.initView(view);


        mPresenter.getJokes(page+"");
        mRv = view.findViewById(R.id.mRv);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpMoudle(new HttpMoudle())
                .build()
                .inject(this);
    }


    @Override
    public void getJokeSuccess(JokesBean jokesBean) {


        List<JokesBean.DataBean> data = jokesBean.getData();
        DuanziAdapter duanziAdapter = new DuanziAdapter(getContext(),data);
        mRv.setAdapter(duanziAdapter);
        duanziAdapter.setOnItemClickListener(new OnItemClickListener() {
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
