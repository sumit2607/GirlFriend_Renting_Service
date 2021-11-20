package com.example.girlfriend_renting_service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static Retrofit getInstance() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build());
        return builder.build();
    }
}
