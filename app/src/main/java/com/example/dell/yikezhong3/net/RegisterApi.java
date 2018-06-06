package com.example.dell.yikezhong3.net;

import com.example.dell.yikezhong3.bean.RegisterBean;

import io.reactivex.Observable;

public class RegisterApi {

    private RegisterApiService registerApiService;
    private static RegisterApi registerApi;
    public RegisterApi(RegisterApiService registerApiService) {
        this.registerApiService = registerApiService;
    }

    public static RegisterApi getRegisterApi(RegisterApiService registerApiService){
        if (registerApi == null){
            registerApi = new RegisterApi(registerApiService);
        }
        return registerApi;
    }

    public Observable<RegisterBean> register(String mobile, String password){

        return registerApiService.register(mobile,password);
    }
}
