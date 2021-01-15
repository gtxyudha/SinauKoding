package com.example.perpus.network.api;

import com.example.perpus.converter.ResponseDataList;
import com.example.perpus.converter.ResponseDataObject;
import com.example.perpus.entity.Loan;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoanApi {
    @GET("loans")
    Call<ResponseDataList<Loan>> defind(@Query("param") String param,
                                        @Query("offset") Integer offset,
                                        @Query("limit") Integer limit);

    @POST("loans")
    Call<ResponseDataObject<Loan>> doAdd(@Body Loan loan);
}
