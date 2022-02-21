package com.example.encardv1.ui.fragments;

import android.os.Bundle;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.encardv1.adapter.ImageAdapter;
import com.example.encardv1.base.BaseFragment;
import com.example.encardv1.databinding.FragmentWordBinding;
import com.example.encardv1.pixabayviewmodel.PixaBayViewModel;


import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WordsFragment extends BaseFragment<FragmentWordBinding> {
    public static int TIME_OUT = 3000;
    private Handler handler;
    ImageAdapter imageAdapter;
    PixaBayViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixaBayViewModel.class);
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
                if (handler != null){
                    handler = null;
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                new Handler().postDelayed(() -> {
                    binding.progressbar.setVisibility(View.VISIBLE);
                    viewModel.getImages(binding.etImage.getText().toString()).observe(getViewLifecycleOwner() , hits -> {
                        if (hits != null){
                            binding.progressbar.setVisibility(View.GONE);
                            imageAdapter.setHits(hits);
                            binding.recyclerview.setAdapter(imageAdapter);
                        }
                    });
                },TIME_OUT);
            }
        });
    }



    @Override
    public FragmentWordBinding bind() {
        return FragmentWordBinding.inflate(getLayoutInflater());
    }

}