package com.example.dell.yikezhong3.ui.shipin.nearby;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.ui.shipin.follow.VFollowContract;

public interface VNearbyContract {

    interface View extends BaseContract.BaseView{

        void getAdSuccess(AdBean adBean);
    }

    interface  Presenter extends BaseContract.BasePresenter<VNearbyContract.View>{

        void getAd(String token, String page);

    }
}
