package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.bean.SelectBean;

import io.reactivex.Observable;

public class SelectApi {
    private  static SelectApi selectApi;
    private SelectApiService  selectApiService;

    public SelectApi(SelectApiService selectApiService) {
        this.selectApiService = selectApiService;
    }
    public static SelectApi getSelectApi(SelectApiService selectApiService){
        if(selectApi==null){
            selectApi=new SelectApi(selectApiService);
        }

        return selectApi;
    }

    public Observable<SelectBean> getSelect(String keywords){

        return selectApiService.getSelect(keywords);
    }
}
