package com.example.encardv1.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.encardv1.App;
import com.example.encardv1.adapter.ImageAdapter;
import com.example.encardv1.base.BaseFragment;
import com.example.encardv1.databinding.FragmentWordBinding;
import com.example.encardv1.network.model.Hits;
import com.example.encardv1.network.model.PixabayResponse;
import com.example.encardv1.pixabayviewmodel.PixaBayViewModel;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class WordsFragment extends BaseFragment<FragmentWordBinding> {
    ImageAdapter imageAdapter;
    PixaBayViewModel viewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(requireParentFragment()).get(PixaBayViewModel.class);
        imageAdapter = new ImageAdapter();
        initListener();
    }

    private void initListener() {
        binding.etImage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.getImages(binding.etImage.getText().toString()).observe(getViewLifecycleOwner() , hits -> {
                    if (hits != null){
                        imageAdapter.setHits(hits);
                        binding.recyclerview.setAdapter(imageAdapter);
                    }
                });
            }
        });
    }

    @Override
    public FragmentWordBinding bind() {
        return FragmentWordBinding.inflate(getLayoutInflater());
    }

}