package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.GenBean;

import io.reactivex.Observable;

public class GeApi {
    private static GeApi geApi;
    private GeApiService geApiService;

    public GeApi(GeApiService geApiService) {
        this.geApiService = geApiService;
    }

    public static GeApi getGeApi(GeApiService geApiService){

        if(geApi == null){
            geApi = new GeApi(geApiService);
        }
        return geApi;
    }

    public Observable<GenBean> getGe(String uid,String page,String token){
        return geApiService.getGe(uid,page,token);
    }
}
