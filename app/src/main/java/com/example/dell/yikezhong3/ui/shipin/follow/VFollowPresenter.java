package com.example.dell.yikezhong3.ui.shipin.follow;

import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.net.AdApi;
import com.example.dell.yikezhong3.net.AttentionApi;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract.AttentionContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VFollowPresenter extends BasePresenter<VFollowContract.View> implements VFollowContract.Presenter{
    private AdApi adApi;

    @Inject
    public VFollowPresenter(AdApi adApi) {
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
                        if(mView!=null){
                            mView.getAdSuccess(adBean);
                        }

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
