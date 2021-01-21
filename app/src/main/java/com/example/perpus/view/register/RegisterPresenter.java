package com.example.perpus.view.register;

import com.example.perpus.callback.SingleCallback;
import com.example.perpus.converter.ResponseDataObject;
import com.example.perpus.entity.User;
import com.example.perpus.network.service.LoginService;

import java.text.ParseException;

import retrofit2.Call;
import retrofit2.Response;

public class RegisterPresenter {

    private RegisterView view;


    public RegisterPresenter(RegisterView view) {
        this.view = view;
    }

    public void doRegister(User param){
        Call<ResponseDataObject<User>> call = LoginService.getInstance().doRegister(param);
        call.enqueue(new SingleCallback<User>() {
            @Override
            public void onDefaultResponse(ResponseDataObject<User> response) throws ParseException {
                if (response.getData() != null){
                    view.onRegisterSuccess(response.getData());
                }
            }
        });
    }

}
