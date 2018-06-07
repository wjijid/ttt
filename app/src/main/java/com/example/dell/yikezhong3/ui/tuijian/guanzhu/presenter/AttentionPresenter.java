package com.example.dell.yikezhong3.ui.tuijian.guanzhu.presenter;

import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.net.AttentionApi;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract.AttentionContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AttentionPresenter extends BasePresenter<AttentionContract.View> implements AttentionContract.Presenter{

    private AttentionApi attentionApi;

    @Inject
    public AttentionPresenter(AttentionApi attentionApi) {
        this.attentionApi = attentionApi;
    }


    @Override
    public void getAttention(String uid, String token) {
        attentionApi.getAttention(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AttentionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttentionBean attentionBean) {

                        mView.getAttentionSuccess(attentionBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
