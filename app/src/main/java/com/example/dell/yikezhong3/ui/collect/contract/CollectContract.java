package com.example.dell.yikezhong3.ui.collect.contract;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.CollectionBean;

public interface CollectContract {

    interface  View extends BaseContract.BaseView{

        void  getCollectSuccess(CollectionBean collectionBean);
    }

    interface Presenter  extends BaseContract.BasePresenter<View>{

        void getCollect(String uid,String token);
    }
}
