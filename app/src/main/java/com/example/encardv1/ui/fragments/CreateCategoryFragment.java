package com.example.encardv1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.encardv1.App;
import com.example.encardv1.R;
import com.example.encardv1.databinding.FragmentCreateCategoryBinding;
import com.example.encardv1.db.model.CategoryModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class CreateCategoryFragment extends BottomSheetDialogFragment {
    FragmentCreateCategoryBinding binding;
    CategoryModel categoryModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateCategoryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
    }

    private void initClickers() {
        binding.createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = binding.etCreate.getText().toString();
                categoryModel = new CategoryModel(category);
                App.getDataBase().categoryDao().insert(categoryModel);
                dismiss();
            }
        });
    }
}