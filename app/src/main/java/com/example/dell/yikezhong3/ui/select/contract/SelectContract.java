package com.example.dell.yikezhong3.ui.select.contract;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.bean.SelectBean;
import com.example.dell.yikezhong3.ui.collect.contract.CollectContract;

public interface SelectContract {

    interface  View extends BaseContract.BaseView{

        void  getSelectSuccess(SelectBean selectBean);
    }

    interface Presenter  extends BaseContract.BasePresenter<SelectContract.View>{

        void getSelect(String token);
    }
}
