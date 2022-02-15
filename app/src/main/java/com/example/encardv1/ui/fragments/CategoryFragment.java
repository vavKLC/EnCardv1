package com.example.encardv1.ui.fragments;

import com.example.encardv1.base.BaseFragment;
import com.example.encardv1.databinding.FragmentCategoryBinding;

public class CategoryFragment extends BaseFragment<FragmentCategoryBinding>{


    @Override
    public FragmentCategoryBinding bind() {
        return FragmentCategoryBinding.inflate(getLayoutInflater());
    }
}