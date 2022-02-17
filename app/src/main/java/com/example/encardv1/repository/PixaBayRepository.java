package com.example.encardv1.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.encardv1.App;
import com.example.encardv1.network.model.Hits;
import com.example.encardv1.network.model.PixabayResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PixaBayRepository {

    static PixaBayRepository pixaBayRepository;

    public static PixaBayRepository getInstance(){
        if (pixaBayRepository == null){
            return new PixaBayRepository();
        }
        return pixaBayRepository;
    }

    public MutableLiveData<List<Hits>> getImages(String word){
        MutableLiveData<List<Hits>> listImage = new MutableLiveData<>();
        App.retrofitClient.providerPixabayApi().getImages(word).enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                if (response.isSuccessful()){
                    listImage.postValue(response.body().getHits());
                }
            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {

            }
        });

        return listImage;
    }
}
