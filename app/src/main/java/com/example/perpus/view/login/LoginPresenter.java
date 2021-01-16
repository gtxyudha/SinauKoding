package com.example.perpus.view.login;

import android.content.Context;

import com.example.perpus.callback.SingleCallback;
import com.example.perpus.common.StatusCode;
import com.example.perpus.converter.ResponseDataObject;
import com.example.perpus.entity.User;
import com.example.perpus.network.service.LoginService;
import com.example.perpus.session.SessionManager;

import java.text.ParseException;

import retrofit2.Call;

public class LoginPresenter {
    final LoginView view;

    final Context context;


    public LoginPresenter(LoginView view, Context context) {
        this.view = view;
        this.context = context;
    }

    void doLogin(User param){
        Call<ResponseDataObject<User>> call = LoginService.getInstance().doLogin(param);
        call.enqueue(new SingleCallback<User>() {
            @Override
            public void onDefaultResponse(ResponseDataObject<User> response) throws ParseException {
                User user = response.getData();
                user.setPassword(param.getPassword());

                SessionManager.getInstance(context).setCurrentLogin(user);

                view.onLoginSuccess(user);
            }

            @Override
            public void onDefaultFailure(Throwable t) {
                super.onDefaultFailure(t);
                view.onLoginFailed(StatusCode.SERVICE_OFFLINE);
            }

            @Override
            public void onGetStatus(String status) {
                super.onGetStatus(status);
                view.onLoginFailed(status);
            }
        });
    }
}
