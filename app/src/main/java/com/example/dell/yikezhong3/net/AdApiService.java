package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AdApiService {

    /**
     * https://www.zhaoapi.cn/quarter/getHotVideos?token=442A977AF5C64DF404F761900020CE70&page=10&source=android&appVersion=1
     * @param token
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST("quarter/getHotVideos")
    Observable<AdBean> getAd(
            @Field("token") String token,
            @Field("page") String page
    );
}
