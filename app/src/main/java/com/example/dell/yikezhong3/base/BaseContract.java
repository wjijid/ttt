package com.example.dell.yikezhong3.base;

    public interface   BaseContract {

    interface BasePresenter<T extends BaseView>{
        void attachView(T view);
        void detachView();
    }

    interface BaseView{
        void showLoading();
        void dimissLoading();
    }
}
