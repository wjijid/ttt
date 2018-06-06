package com.example.dell.yikezhong3.ui.follow.contract;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.FllowBean;

public interface FollowContract {

    interface View extends BaseContract.BaseView{
        void getFollowSuccess(FllowBean fllowBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getFollow(String uid,String token);
    }
}
