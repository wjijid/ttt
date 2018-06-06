package com.example.dell.yikezhong3.ui.regin.contract;


import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.RegisterBean;

public interface RegisterContract {

    interface View extends BaseContract.BaseView{
        void registerSuccess(RegisterBean registerBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void register(String mobile, String password);
    }

}
