package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.FllowBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FollowApiService {

    @FormUrlEncoded
    @POST("quarter/getFollowUsers")
    Observable<FllowBean> getFollow(@Field("uid") String uid,@Field("token") String token);
}
