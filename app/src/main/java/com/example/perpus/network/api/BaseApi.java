package com.example.perpus.network.api;

public interface BaseApi {
    BookApi getBookApi();

    LoanApi getLoanApi();

    LoginApi getLoginApi();
}
