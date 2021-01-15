package com.example.perpus.network.service;

import com.example.perpus.converter.ResponseDataList;
import com.example.perpus.entity.Book;
import com.example.perpus.network.api.BaseApi;

import retrofit2.Call;
import retrofit2.http.Query;

public class BookService extends BaseService {
    protected static BookService instance;

    public static BookService getInstance(){
        if (instance == null){
            instance = new BookService();
        }
        return instance;
    }

    public Call<ResponseDataList<Book>> defindBook(@Query("param") String param,
                                                   @Query("offset") Integer offset,
                                                   @Query("limit") Integer limit){
        return baseApi.getBookApi().defind(param, offset, limit);
    }


}
