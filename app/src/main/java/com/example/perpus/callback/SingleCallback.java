package com.example.perpus.callback;

import android.os.Handler;
import android.os.Looper;

import com.example.perpus.converter.ResponseDataObject;


import java.text.ParseException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class SingleCallback<T> implements Callback<ResponseDataObject<T>> {
    @Override
    public void onResponse(Call<ResponseDataObject<T>> call, Response<ResponseDataObject<T>> response) {
        new Handler(Looper.getMainLooper()).post(() -> {
            if (response.isSuccessful() && response.body() != null){
                if(response.body().getData() != null){
                    try {
                            onDefaultResponse(response.body());
                    } catch (ParseException e){
                        e.printStackTrace();
                    }
                } else{
                        validateStatusCode(response.body());
                }
            } else {
                onGetStatus("status");
            }
        });
    }

    @Override
    public void onFailure(Call<ResponseDataObject<T>> call, Throwable t) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                try {
                    onDefaultFailure(t);
                } finally {

                }
            }
        });
    }

    void validateStatusCode(ResponseDataObject<T> response){
        if (response.getStatus() != null){
            onGetStatus(response.getStatus());
        }
    }

    public abstract void onDefaultResponse(ResponseDataObject<T> response) throws ParseException;

    public void onDefaultFailure(Throwable t){
        onGetStatus("status");
    }

    public void onGetStatus (String status){

    }
}
