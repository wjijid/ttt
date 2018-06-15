package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.SelectBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SelectApiService {

    @FormUrlEncoded
    @POST("quarter/searchFriends")
    Observable<SelectBean> getSelect(@Field("keywords") String  keywords);


}
