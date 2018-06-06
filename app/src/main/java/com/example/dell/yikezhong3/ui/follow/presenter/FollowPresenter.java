package com.example.dell.yikezhong3.ui.follow.presenter;

import com.example.dell.yikezhong3.base.BasePresenter;
import com.example.dell.yikezhong3.bean.FllowBean;
import com.example.dell.yikezhong3.net.FollowApi;
import com.example.dell.yikezhong3.ui.follow.contract.FollowContract;
import com.example.dell.yikezhong3.ui.login.contract.LoginContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FollowPresenter extends BasePresenter<FollowContract.View> implements FollowContract.Presenter {

    private FollowApi followApi;

    public FollowPresenter(FollowApi followApi) {
        this.followApi = followApi;
    }

    @Override
    public void getFollow(String uid, String token) {
        followApi.getFollow(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FllowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FllowBean fllowBean) {
                         mView.getFollowSuccess(fllowBean);
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
