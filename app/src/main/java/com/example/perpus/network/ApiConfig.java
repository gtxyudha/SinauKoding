package com.example.perpus.network;

import com.example.perpus.BuildConfig;
import com.example.perpus.network.api.BaseApi;
import com.example.perpus.network.api.BookApi;
import com.example.perpus.network.api.LoanApi;
import com.example.perpus.network.api.LoginApi;
import com.example.perpus.network.service.LoanService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//implements BASEAPI
public class ApiConfig implements BaseApi {

    private static class ApiConfigHolder{
        static final ApiConfig INSTANCE = new ApiConfig();
    }

    public static ApiConfig getInstance(){
        return ApiConfigHolder.INSTANCE;
    }

    @Override
    public BookApi getBookApi() {
        return ApiService.createService(BookApi.class);
    }

    @Override
    public LoanApi getLoanApi() {
        return ApiService.createService(LoanApi.class);
    }

    @Override
    public LoginApi getLoginApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BEST_API)
                .callbackExecutor(Executors.newCachedThreadPool())
                .validateEagerly(true)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(LoginApi.class);
    }
}
