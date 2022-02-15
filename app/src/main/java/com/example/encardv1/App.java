package com.example.encardv1;

import android.app.Application;

import com.example.encardv1.network.PixabayAPI;
import com.example.encardv1.network.RetrofitClient;

public class App extends Application {
    public static RetrofitClient retrofitClient;
    PixabayAPI api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.providerPixabayApi();
    }
}
