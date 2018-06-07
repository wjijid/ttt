package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.CollectionBean;

import io.reactivex.Observable;

public class CollectApi {

    private static CollectApi collectApi;
    private CollectApiService collectApiService;

    public CollectApi(CollectApiService collectApiService) {
        this.collectApiService = collectApiService;
    }

    public static CollectApi getCollectApi(CollectApiService  collectApiService){

        if(collectApi==null){

            collectApi=new CollectApi(collectApiService);
        }
        return collectApi;
    }

    public Observable<CollectionBean>  getCollect(String  uid,String token){

        return  collectApiService.getCollect(uid,token);
    }
}
