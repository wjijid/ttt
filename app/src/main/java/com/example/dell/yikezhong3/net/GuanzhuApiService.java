package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.bean.GuanzhuBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GuanzhuApiService {

    @FormUrlEncoded
    @POST("quarter/getUserVideos")
    Observable<CollectionBean> getGuan(@Field("uid") String uid, @Field("page") String page);
}
