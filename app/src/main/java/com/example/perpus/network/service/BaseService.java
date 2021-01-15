package com.example.perpus.network.service;

import com.example.perpus.network.ApiProxy;
import com.example.perpus.network.api.BaseApi;

import java.lang.reflect.Proxy;

public class BaseService {
    protected BaseApi baseApi;

    protected BaseService(){
        baseApi = (BaseApi) Proxy.newProxyInstance(BaseApi.class.getClassLoader(), new Class[]{BaseApi.class}, new ApiProxy());
    }
}
