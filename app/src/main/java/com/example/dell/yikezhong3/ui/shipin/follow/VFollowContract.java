package com.example.dell.yikezhong3.ui.shipin.follow;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract.AttentionContract;

public class VFollowContract {

    interface View extends BaseContract.BaseView{

        void getAdSuccess(AdBean adBean);
    }

    interface  Presenter extends BaseContract.BasePresenter<VFollowContract.View>{

        void getAd(String token, String page);

    }
}
