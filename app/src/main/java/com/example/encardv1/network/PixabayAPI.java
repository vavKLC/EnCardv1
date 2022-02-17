package com.example.encardv1.network;

import com.example.encardv1.network.model.PixabayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayAPI {
    @GET("/api?key=25686234-135e53b59045c28ce4d914efc")
    Call<PixabayResponse> getImages( @Query("q") String englishWord);
}
