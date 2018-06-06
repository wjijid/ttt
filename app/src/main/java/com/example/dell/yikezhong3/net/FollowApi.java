package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.FllowBean;

import io.reactivex.Observable;

public class FollowApi {
    private FollowApiService followApiService;
    private static FollowApi followApi;

    public FollowApi(FollowApiService followApiService) {
        this.followApiService = followApiService;
    }

    public static FollowApi getFollowApi(FollowApiService followApiService){
        if(followApi == null){
            followApi = new FollowApi(followApiService);
        }
        return followApi;
    }

    public Observable<FllowBean> getFollow(String uid,String token){
        return followApiService.getFollow(uid,token);
    }
}
