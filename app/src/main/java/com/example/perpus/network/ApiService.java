package com.example.perpus.network;

import com.example.perpus.BuildConfig;
import com.example.perpus.interceptor.RequestBuilderInterceptor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiService instance = null;

    private static OkHttpClient.Builder httpClient = null;

    private static Retrofit retrofit = null;

    private static synchronized ApiService getInstance(){
        if (instance == null){
            synchronized (ApiService.class){
                if (instance == null){
                    instance = new ApiService();
                }
            }
        }
        return instance;
    }

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BuildConfig.BEST_API)
            .callbackExecutor(Executors.newCachedThreadPool())
            .validateEagerly(true)
            .addConverterFactory(GsonConverterFactory.create());

    static <S> S createService(Class<S> serviceClass){
        if (httpClient == null){
            httpClient = new OkHttpClient.Builder();
        }

        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        httpClient.addInterceptor(new RequestBuilderInterceptor());
        httpClient.connectTimeout(1, TimeUnit.MINUTES);
        httpClient.readTimeout(60, TimeUnit.SECONDS);
        httpClient.writeTimeout(60, TimeUnit.SECONDS);

        OkHttpClient client = httpClient.build();

        if (retrofit == null){
            retrofit = builder.client(client).build();
        }

        return retrofit.create(serviceClass);

    }

}
