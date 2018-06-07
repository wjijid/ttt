package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.AttentionBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AttentionApiService {

    /**
     *
     *https://www.zhaoapi.cn/quarter/follow
     *https://www.zhaoapi.cn/quarter/getVideos?source=android&appVersion=1
     *https://www.zhaoapi.cn/user/login?mobile=17600366571&password=123456
     *       DEEDFF540856EC880DC7EB2F8C16C7E5   14445
     *https://www.zhaoapi.cn/user/login?mobile=15535912393&password=123456
     *
     *      1026
     * @return
     */
    @FormUrlEncoded
    @POST("quarter/getFollowUsers")
    Observable<AttentionBean> getAttention(
            @Field("uid") String  uid,
            @Field("token") String  token

            );
}
