package com.example.dell.yikezhong3.ui.tuijian.guanzhu.contract;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.AttentionBean;

public interface AttentionContract {

    interface View extends BaseContract.BaseView{

        void  getAttentionSuccess(AttentionBean attentionBean);
    }
    
    interface  Presenter extends BaseContract.BasePresenter<View>{

        void  getAttention(String uid,String token);
    }
}
