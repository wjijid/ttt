package com.example.dell.yikezhong3.ui.login.contract;


import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.UserBean;

public interface LoginContract {
    interface View extends BaseContract.BaseView {
        void loginSuccess(UserBean userBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String mobile, String password);
    }
}
