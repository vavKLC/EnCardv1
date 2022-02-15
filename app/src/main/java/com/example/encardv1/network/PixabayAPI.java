package com.example.encardv1.network;

import com.example.encardv1.network.model.PixabayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayAPI {
    @GET("/api")
    Call<PixabayResponse> getImages(@Query("key") String key , @Query("q") String englishWord);
}
