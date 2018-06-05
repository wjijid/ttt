package com.example.dell.yikezhong3.ui.duanzi.presenter;

import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.JokesBean;
import com.example.dell.yikezhong3.net.JokesApi;
import com.example.dell.yikezhong3.ui.duanzi.contract.DuanziContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DuanziPresenter extends BasePresenter<DuanziContract.View> implements DuanziContract.Presenter {

    private JokesApi jokesApi;

    @Inject
    public DuanziPresenter(JokesApi jokesApi) {
        this.jokesApi = jokesApi;
    }

    @Override
    public void getJokes(String page) {

        jokesApi.getDuanzi(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<JokesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokesBean jokesBean) {

                        mView.getJokeSuccess(jokesBean);
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
