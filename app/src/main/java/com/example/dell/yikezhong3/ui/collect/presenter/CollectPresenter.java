package com.example.dell.yikezhong3.ui.collect.presenter;

import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.net.CollectApi;
import com.example.dell.yikezhong3.ui.collect.contract.CollectContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CollectPresenter  extends BasePresenter<CollectContract.View> implements CollectContract.Presenter{

    private CollectApi collectApi;

    @Inject
    public CollectPresenter(CollectApi collectApi) {
        this.collectApi = collectApi;
    }

    @Override
    public void getCollect(String uid, String token) {
        collectApi.getCollect(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CollectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CollectionBean collectionBean) {

                        mView.getCollectSuccess(collectionBean);
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
