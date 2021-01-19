package com.example.perpus.interceptor;

import com.example.perpus.entity.User;
import com.example.perpus.session.SessionManager;
import com.example.perpus.view.MainActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestBuilderInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request.Builder requestBuilder;
        Request original = chain.request();

        String token = null;

        User currentUser = SessionManager.getInstance(MainActivity.getInstance()).getCurrentLogin();

        if (currentUser != null && currentUser.getToken() != null){
            token = currentUser.getToken();
        }

        if (token != null){
            requestBuilder = original.newBuilder()
                    .header("Authorization", token)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body());
        } else {
            requestBuilder = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body());
        }

        Request request = requestBuilder.build();


        return chain.proceed(request);
    }
}
