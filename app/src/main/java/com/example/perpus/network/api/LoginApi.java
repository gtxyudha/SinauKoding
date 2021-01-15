package com.example.perpus.network.api;

import com.example.perpus.converter.ResponseDataObject;
import com.example.perpus.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("auth/do-login")
    Call<ResponseDataObject<User>> doLogin (@Body User user);

    @POST("auth/do-register")
    Call<ResponseDataObject<User>> doRegister (@Body User user);
}
