package com.example.dell.yikezhong3.ui.gerenxq.presenter;

import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.GenBean;
import com.example.dell.yikezhong3.net.GeApi;
import com.example.dell.yikezhong3.ui.gerenxq.contract.Mycontract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyPresenter extends BasePresenter<Mycontract.View> implements Mycontract.Presenter {

    private GeApi geApi;

    @Inject
    public MyPresenter(GeApi geApi) {
        this.geApi = geApi;
    }


    @Override
    public void getGe(String uid, String page, String token) {
        geApi.getGe(uid,page,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GenBean genBean) {
                       mView.getGeSuccess(genBean);
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
