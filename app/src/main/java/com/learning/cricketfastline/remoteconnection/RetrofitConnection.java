package com.learning.cricketfastline.remoteconnection;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();


    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApiUrl.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    public static ApiService callApi() {
        ApiService apiInterface = retrofit.create(ApiService.class);
        return apiInterface;
    }

    public static NewApiService callNewsApi() {
        NewApiService apiInterface = retrofitfornews.create(NewApiService.class);
        return apiInterface;
    }


    static Retrofit retrofitfornews = new Retrofit.Builder()
            .baseUrl(ApiUrl.BASE_URL_NEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

}
