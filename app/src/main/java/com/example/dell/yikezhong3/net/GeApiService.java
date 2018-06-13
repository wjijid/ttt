package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.GenBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GeApiService {

    @FormUrlEncoded
    @POST("quarter/getUserVideos")
    Observable<GenBean> getGe(
            @Field("uid") String uid,
            @Field("page") String page,
            @Field("token") String token
    );
}
