package com.example.dell.yikezhong3.ui.regin.presenter;

import android.util.AndroidException;


import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.RegisterBean;
import com.example.dell.yikezhong3.net.RegisterApi;
import com.example.dell.yikezhong3.ui.regin.contract.RegisterContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {

    RegisterApi registerApi;
    @Inject
    public RegisterPresenter(RegisterApi registerApi) {
        this.registerApi = registerApi;
    }

    @Override
    public void register(String mobile, String password) {

        registerApi.register(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                        mView.registerSuccess();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
