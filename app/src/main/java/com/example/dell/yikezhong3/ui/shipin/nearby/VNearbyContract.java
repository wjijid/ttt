package com.example.dell.yikezhong3.ui.shipin.nearby;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.bean.JokesBean;
import com.example.dell.yikezhong3.ui.shipin.follow.VFollowContract;

public interface VNearbyContract {

    interface View extends BaseContract.BaseView{

        void getJokeSuccess(JokesBean jokesBean);
    }

    interface  Presenter extends BaseContract.BasePresenter<VNearbyContract.View>{

        void getJokes(String page);

    }
}
