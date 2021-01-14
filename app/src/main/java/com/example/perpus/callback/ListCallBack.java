package com.example.perpus.callback;

import android.os.Handler;
import android.os.Looper;

import com.example.perpus.converter.ResponseDataList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ListCallBack<T> implements Callback<ResponseDataList<T>> {


    @Override
    public void onResponse(Call<ResponseDataList<T>> call, Response<ResponseDataList<T>> response) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                if (response.isSuccessful() && response.body() != null){
                    if (response.body().getData() != null){
                        onDefaultResponse(response.body());
                    }else {
                            validationStatusCode(response.body());
                    }
                }else {
                    onGetStatus(response.body().getStatus());
                }
            }
        });
    }

    @Override
    public void onFailure(Call<ResponseDataList<T>> call, Throwable t) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                try {
                    onDefaultFailure(t);
                }finally {

                }
            }
        });
    }

    void validationStatusCode(ResponseDataList<T> response){
        if(response.getStatus() != null){

        }
    }

    public abstract void onDefaultResponse(ResponseDataList<T> response);

    public void onDefaultFailure(Throwable t){

    }

    public void onGetStatus(String statusCode){
        if (statusCode != null){

        }
    }

}
