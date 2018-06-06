package com.example.dell.yikezhong3.moudle;

import com.example.dell.yikezhong3.net.AdApi;
import com.example.dell.yikezhong3.net.AdApiService;
import com.example.dell.yikezhong3.net.Api;
import com.example.dell.yikezhong3.net.JokesApi;
import com.example.dell.yikezhong3.net.JokesApiService;
import com.example.dell.yikezhong3.net.LoginApi;
import com.example.dell.yikezhong3.net.LoginApiService;
import com.example.dell.yikezhong3.net.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpMoudle {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    JokesApi provideJokesApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        JokesApiService jokesApiService = retrofit.create(JokesApiService.class);
        return JokesApi.getJokesApi(jokesApiService);
    }

    @Provides
    AdApi provideAdApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AdApiService adApiService = retrofit.create(AdApiService.class);
        return AdApi.getAdApi(adApiService);
    }

    //登录
    @Provides
    LoginApi provideLoginApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiService);
    }
}
