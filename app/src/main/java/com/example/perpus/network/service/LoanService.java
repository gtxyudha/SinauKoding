package com.example.perpus.network.service;



import com.example.perpus.converter.ResponseDataList;
import com.example.perpus.converter.ResponseDataObject;
import com.example.perpus.entity.Loan;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Query;

public class LoanService extends BaseService {
    private static LoanService instance;

    public static LoanService getInstance(){
        if (instance == null){
            instance = new LoanService();
        }

        return instance;
    }

    public Call<ResponseDataList<Loan>> defind (@Query("param") String param,
                                                @Query("offset") Integer offset,
                                                @Query("limit") Integer limit){
        return baseApi.getLoanApi().defind(param, offset, limit);
    }

    public Call<ResponseDataObject<Loan>> defind(@Body Loan loan){
        return baseApi.getLoanApi().doAdd(Loan);
    }

}
