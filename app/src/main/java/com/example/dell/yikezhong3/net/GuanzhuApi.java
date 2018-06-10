package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.bean.GuanzhuBean;

import io.reactivex.Observable;

public class GuanzhuApi {

    private GuanzhuApiService guanzhuApiService;
    private static GuanzhuApi guanzhuApi;

    public GuanzhuApi(GuanzhuApiService guanzhuApiService) {
        this.guanzhuApiService = guanzhuApiService;
    }

    public static GuanzhuApi guanzhuApi(GuanzhuApiService guanzhuApiService){
        if(guanzhuApi == null){
            guanzhuApi = new GuanzhuApi(guanzhuApiService);
        }
        return guanzhuApi;
    }

    public Observable<CollectionBean> getGuan(String uid, String page){
        return guanzhuApiService.getGuan(uid,page);
    }
}
