package com.example.perpus.network.api;

import com.example.perpus.converter.ResponseDataList;
import com.example.perpus.entity.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookApi {
    @GET("book")
    Call<ResponseDataList<Book>> defind (@Query("param") String param,
                                         @Query("offset") Integer ofset,
                                         @Query("limit") Integer limit);



}
