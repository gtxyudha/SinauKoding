package com.example.perpus.view.login;

import com.example.perpus.entity.User;

public interface LoginView {
    void onLoginSuccess(User user);

    void onLoginFailed(String statusCode);
}
