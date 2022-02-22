package com.example.encardv1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.encardv1.databinding.FragmentBoardBinding;
import com.example.encardv1.interfaces.OnItemClickListener;
import com.example.encardv1.network.model.ViewPagerModel;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>{
    ArrayList<ViewPagerModel> listPager;
    OnItemClickListener listener;

    public ViewPagerAdapter(ArrayList<ViewPagerModel> listPager, OnItemClickListener listener) {
        this.listPager = listPager;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerHolder(FragmentBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ViewPagerHolder holder, int position) {
        holder.onBind(listPager.get(position));
    }


    @Override
    public int getItemCount() {
        return listPager.size();
    }

    public class ViewPagerHolder extends RecyclerView.ViewHolder {
    private final FragmentBoardBinding binding;
        public ViewPagerHolder(FragmentBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(ViewPagerModel model) {
            binding.imImage.setImageResource(model.getImg());
            binding.tvPagerText1.setText(model.getText1());
            binding.tvPagerText2.setText(model.getText2());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick();
                }
            });
        }
    }
}
