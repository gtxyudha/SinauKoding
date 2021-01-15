package com.example.perpus.network.service;

import com.example.perpus.converter.ResponseDataObject;
import com.example.perpus.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;

public class LoginService extends BaseService {
    private static LoginService instance;

    public static LoginService getInstance(){
        if (instance == null){
            instance = new LoginService();
        }
        return instance;
    }

    public Call<ResponseDataObject<User>> doLogin (@Body User user){
        return baseApi.getLoginApi().doLogin(user);
    }

    public Call<ResponseDataObject<User>> doRegister (@Body User param){
        return baseApi.getLoginApi().doRegister(param);
    }
}
