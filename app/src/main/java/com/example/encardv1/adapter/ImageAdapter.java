package com.example.encardv1.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.encardv1.databinding.ImageHolderListBinding;
import com.example.encardv1.network.model.Hits;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    List<Hits> hits = new ArrayList<>();

    @NonNull
    @Override
    public ImageAdapter.ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageHolder(ImageHolderListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageHolder holder, int position) {
        holder.onBind(hits.get(position));
    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        ImageHolderListBinding binding;

        public ImageHolder(ImageHolderListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Hits hits) {
            Glide.with(binding.imImage).load(hits.getLargeImageURL()).into(binding.imImage);
        }
    }
}
