package com.example.encardv1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;

import com.example.encardv1.R;
import com.example.encardv1.adapter.ViewPagerAdapter;
import com.example.encardv1.base.BaseFragment;
import com.example.encardv1.client.PagerClient;
import com.example.encardv1.databinding.FragmentMainBoardBinding;
import com.example.encardv1.interfaces.OnItemClickListener;
import com.example.encardv1.pixabayviewmodel.PixaBayViewModel;




import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainBoardFragment extends BaseFragment<FragmentMainBoardBinding> implements OnItemClickListener {
    ViewPagerAdapter adapter;
    PixaBayViewModel viewModel;
    PagerClient client;


    @Override
    public FragmentMainBoardBinding bind() {
        return FragmentMainBoardBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixaBayViewModel.class);
        initAdapter();
        init();
        checkOnShow();
    }


    private void init() {
        binding.btnLets.setOnClickListener(view -> {
            viewModel.setBoolean(true);
            Navigation.findNavController(requireView()).navigate(R.id.wordsFragment);
        });
    }

    private void checkOnShow(){
        if (viewModel.getBoolean()){
            Navigation.findNavController(requireView()).navigate(R.id.wordsFragment);
        }else {
            viewModel.setBoolean(false);
        }
    }

    @Override
    public void itemClick() {
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (position == 4){
                    binding.btnLets.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void initAdapter() {
        adapter = new ViewPagerAdapter(client.getList(), this);
        binding.viewPager.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(binding.viewPager);
    }
}