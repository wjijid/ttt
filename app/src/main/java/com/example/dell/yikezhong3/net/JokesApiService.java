package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.JokesBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JokesApiService {

    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<JokesBean> getDuanzi(@Field("page") String page);
}
