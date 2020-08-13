package com.demo.mypetapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api api;
    private Retrofit retrofit;

    private Api(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://app-demo-web-august.web.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static Api getApi(){
        if(api == null){
            api = new Api();
        }
        return  api;
    }

    public ApiService getApiService(){
        return retrofit.create(ApiService.class);
    }
}
