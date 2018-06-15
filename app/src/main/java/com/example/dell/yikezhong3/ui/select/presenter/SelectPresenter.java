package com.example.dell.yikezhong3.ui.select.presenter;

import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.bean.SelectBean;
import com.example.dell.yikezhong3.net.SelectApi;
import com.example.dell.yikezhong3.ui.collect.contract.CollectContract;
import com.example.dell.yikezhong3.ui.select.contract.SelectContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SelectPresenter extends BasePresenter<SelectContract.View> implements SelectContract.Presenter{


    private SelectApi selectApi;

    @Inject
    public SelectPresenter(SelectApi selectApi) {
        this.selectApi = selectApi;
    }

    @Override
    public void getSelect(String token) {
        selectApi.getSelect(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SelectBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SelectBean selectBean) {
                        if(mView!=null){
                            mView.getSelectSuccess(selectBean);
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
