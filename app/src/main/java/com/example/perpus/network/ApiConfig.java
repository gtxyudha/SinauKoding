package com.example.perpus.network;

import com.example.perpus.network.api.BaseApi;

//implements BASEAPI
public class ApiConfig extends BaseApi {

    private static class ApiConfigHolder{
        static final ApiConfig INSTANCE = new ApiConfig();
    }

    public static ApiConfig getInstance(){
        return ApiConfigHolder.INSTANCE;
    }
}
