package com.example.dell.yikezhong3.moudle;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.net.AdApi;
import com.example.dell.yikezhong3.net.AdApiService;
import com.example.dell.yikezhong3.net.Api;
import com.example.dell.yikezhong3.net.AttentionApi;
import com.example.dell.yikezhong3.net.AttentionApiService;
import com.example.dell.yikezhong3.net.CollectApi;
import com.example.dell.yikezhong3.net.CollectApiService;
import com.example.dell.yikezhong3.net.FollowApi;
import com.example.dell.yikezhong3.net.FollowApiService;
import com.example.dell.yikezhong3.net.GuanzhuApi;
import com.example.dell.yikezhong3.net.GuanzhuApiService;
import com.example.dell.yikezhong3.net.JokesApi;
import com.example.dell.yikezhong3.net.JokesApiService;
import com.example.dell.yikezhong3.net.LoginApi;
import com.example.dell.yikezhong3.net.LoginApiService;
import com.example.dell.yikezhong3.net.MyInterceptor;
import com.example.dell.yikezhong3.net.RegisterApi;
import com.example.dell.yikezhong3.net.RegisterApiService;

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

    //推荐---->热门
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
    //注册
    @Provides
    RegisterApi providesResisterApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        RegisterApiService registerApiService = retrofit.create(RegisterApiService.class);
        return RegisterApi.getRegisterApi(registerApiService);
    }
    //我的关注
    @Provides
    FollowApi providesFollwoApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        FollowApiService followApiService = retrofit.create(FollowApiService.class);
        return FollowApi.getFollowApi(followApiService);
    }

    //推荐---->关注

    @Provides
    AttentionApi provideAttentionApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        AttentionApiService  attentionApiService=retrofit.create(AttentionApiService.class);

        return  AttentionApi.getAttentionApi(attentionApiService);
    }

    //收藏
    @Provides
    CollectApi provideCollectApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        CollectApiService collectApiService=retrofit.create(CollectApiService.class);

        return  CollectApi.getCollectApi(collectApiService);
    }

    //详情
    @Provides
    GuanzhuApi provideGuanzhuApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        GuanzhuApiService guanzhuApiService = retrofit.create(GuanzhuApiService.class);
        return GuanzhuApi.guanzhuApi(guanzhuApiService);
    }


}
