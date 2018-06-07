package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.AttentionBean;

import io.reactivex.Observable;


public class AttentionApi {


    private static AttentionApi attentionApi;
    private AttentionApiService attentionApiService;

    public AttentionApi(AttentionApiService attentionApiService) {
        this.attentionApiService = attentionApiService;
    }

    public static AttentionApi getAttentionApi(AttentionApiService attentionApiService){

        if(attentionApi==null){
            attentionApi=new AttentionApi(attentionApiService);
        }

        return attentionApi;
    }

    public Observable<AttentionBean> getAttention(String uid, String  token){

        return attentionApiService.getAttention(uid,token);
    }

}
