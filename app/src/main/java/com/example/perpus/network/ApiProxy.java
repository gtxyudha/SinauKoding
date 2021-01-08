package com.example.perpus.network;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ApiProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(ApiConfig.getInstance(), args);


    }
}
