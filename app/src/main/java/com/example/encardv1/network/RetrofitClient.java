package com.example.encardv1.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public PixabayAPI providerPixabayApi(){
        return retrofit.create(PixabayAPI.class);
    }
}
