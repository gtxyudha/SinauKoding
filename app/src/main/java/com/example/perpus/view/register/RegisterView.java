package com.example.perpus.view.register;

import com.example.perpus.entity.User;

public interface RegisterView {
    void onRegisterSuccess(User user);

    void onRegisterFailed(String statusCode);
}
