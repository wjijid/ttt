package com.example.dell.yikezhong3.ui.regin.contract;


import com.example.dell.yikezhong3.base.BaseContract;

public interface RegisterContract {

    interface View extends BaseContract.BaseView{
        void registerSuccess();
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void register(String mobile, String password);
    }

}
