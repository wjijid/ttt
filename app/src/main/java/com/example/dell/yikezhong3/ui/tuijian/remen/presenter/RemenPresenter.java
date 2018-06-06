package com.example.dell.yikezhong3.ui.tuijian.remen.presenter;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.net.AdApi;
import com.example.dell.yikezhong3.ui.tuijian.remen.contract.RemenContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RemenPresenter extends BasePresenter<RemenContract.View> implements RemenContract.presenter{

    private AdApi adApi;

    @Inject
    public RemenPresenter(AdApi adApi) {
        this.adApi = adApi;
    }

    @Override
    public void getAd(String token, String page) {
        adApi.getAd(token,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                        mView.getAdSuccess(adBean);
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
