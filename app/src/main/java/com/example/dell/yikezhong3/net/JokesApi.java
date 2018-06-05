package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.JokesBean;

import io.reactivex.Observable;

public class JokesApi {

    private JokesApiService jokesApiService;
    private static JokesApi jokesApi;

    public JokesApi(JokesApiService jokesApiService) {
        this.jokesApiService = jokesApiService;
    }

    public static JokesApi getJokesApi(JokesApiService jokesApiService){
        if(jokesApi == null){
            jokesApi = new JokesApi(jokesApiService);
        }
        return jokesApi;
    }

    public Observable<JokesBean> getDuanzi(String page){
        return jokesApiService.getDuanzi(page);
    }
}
