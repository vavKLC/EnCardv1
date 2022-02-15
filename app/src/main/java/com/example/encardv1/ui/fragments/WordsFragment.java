package com.example.encardv1.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.encardv1.App;
import com.example.encardv1.adapter.ImageAdapter;
import com.example.encardv1.base.BaseFragment;
import com.example.encardv1.databinding.FragmentWordBinding;
import com.example.encardv1.network.model.Hits;
import com.example.encardv1.network.model.PixabayResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordsFragment extends BaseFragment<FragmentWordBinding> {
    ImageAdapter imageAdapter;


    @Override
    public FragmentWordBinding bind() {
        return FragmentWordBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageAdapter = new ImageAdapter();
        getImage();
    }

    private void getImage() {
        binding.btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = binding.etImage.getText().toString();
                App.retrofitClient.providerPixabayApi().getImages("25686234-135e53b59045c28ce4d914efc" , s)
                        .enqueue(new Callback<PixabayResponse>() {
                            @Override
                            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                                imageAdapter.setHits((List<Hits>) response.body().getHits());
                                binding.recyclerview.setAdapter(imageAdapter);
                            }

                            @Override
                            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                                Log.e("fail", "onFailure: ");
                            }
                        });
            }
        });

    }

}