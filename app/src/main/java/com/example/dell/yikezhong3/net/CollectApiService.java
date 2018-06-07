package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.CollectionBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CollectApiService {

    @FormUrlEncoded
    @POST("quarter/getFavorites")
    io.reactivex.Observable<CollectionBean> getCollect(
            @Field("uid") String uid,
            @Field("token")String token
    );
}
