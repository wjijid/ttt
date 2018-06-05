package com.example.dell.yikezhong3.ui.duanzi.contract;

import com.example.dell.yikezhong3.base.BaseContract;
import com.example.dell.yikezhong3.bean.JokesBean;

public interface DuanziContract {

    interface View extends BaseContract.BaseView{
         void getJokeSuccess(JokesBean jokesBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getJokes(String page);
    }
}
