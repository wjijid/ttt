package com.example.dell.yikezhong3.ui.tuijian.remen.contract;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.AdBean;

public interface RemenContract {

    interface  View extends BaseContract.BaseView{
        void getAdSuccess(AdBean adBean);


    }


    interface presenter  extends  BaseContract.BasePresenter<View>{
        void getAd(String token, String page);



    }
}
