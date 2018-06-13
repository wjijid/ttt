package com.example.dell.yikezhong3.ui.gerenxq.contract;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.GenBean;

public interface Mycontract {

    interface View extends BaseContract.BaseView{
        void getGeSuccess(GenBean genBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getGe(String uid,String page,String token);
    }
}
